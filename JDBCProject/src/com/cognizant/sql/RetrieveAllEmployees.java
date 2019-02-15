package com.cognizant.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveAllEmployees {

	public static void main(String []args)
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection=null;
		try {
		 connection=	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","SYSTEM","cognizant");
		Statement statement=connection.createStatement();
		ResultSet resultSet= statement.executeQuery("select * from EMPLOYEESCOGNIZANT");
		System.out.println("EMP ID \t"+"EMP NAME \t"+ "EMP SALARY \t" + "EMP DESIGNATION \n");
		while(resultSet.next())
		{
			System.out.println(resultSet.getInt("EMP_ID")+"\t"+
					resultSet.getString("EMP_NAME")+"\t"+
					resultSet.getDouble("EMP_SALARY")+"\t"+
					resultSet.getString("EMP_DESIGNATION"));
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
