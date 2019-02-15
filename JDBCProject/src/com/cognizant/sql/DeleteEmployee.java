package com.cognizant.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(
				Scanner sc=new Scanner(System.in);
				Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","SYSTEM","cognizant");
		)
		{
			System.out.println("Enter Employee Id:");
			int empId=sc.nextInt();
			
			PreparedStatement statement=connection.prepareStatement("delete from EMPLOYEESCOGNIZANT where emp_id=?");
			statement.setInt(1, empId);
			int rows = statement.executeUpdate();
			if(rows>0)
			{
				System.out.print("Record Updated \n");
				Statement statements =connection.createStatement();
				ResultSet resultSet =statements.executeQuery("Select * from EMPLOYEESCOGNIZANT");
				while(resultSet.next())
				{
					System.out.println(resultSet.getInt("EMP_ID")+"\t"+
							resultSet.getString("EMP_NAME")+"\t"+
							resultSet.getDouble("EMP_SALARY")+"\t"+
							resultSet.getString("EMP_DESIGNATION"));
				}
			}
			else
			{
				System.out.print("Insert failed");
			}
			
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
