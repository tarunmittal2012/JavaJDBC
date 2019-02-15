package com.cognizant.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RetrieveEmployeeBasedOnId {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//try-with resources
		try(
				Scanner sc=new Scanner(System.in);
				Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","SYSTEM","cognizant");
		)
		{
			System.out.println("Enter Employee Id:");
			int emp=sc.nextInt();
			PreparedStatement statement=connection.prepareStatement("select * from EMPLOYEESCOGNIZANT where EMP_ID=?");
			statement.setInt(1, emp);
			ResultSet resultSet= statement.executeQuery();
			System.out.println("EMP_ID" +"\t" +"EMP_NAME" + "\t" + "EMP_SALARY"+"\t"+"EMP_DES");
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt(1) +"\t" + resultSet.getString(2)+"\t" +
						resultSet.getDouble(3)+"\t" + resultSet.getString(4));
			}
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
