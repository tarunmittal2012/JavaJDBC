package com.cognizant.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertEmployee {

	public static void main(String[] args)
	{
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
			int emp=sc.nextInt();
			System.out.println("Enter Employee Name:");
			String emp_name=sc.next();
			System.out.println("Enter Employee Salary:");
			double emp_sal=sc.nextDouble();
			System.out.println("Enter Employee Designation:");
			String emp_des=sc.next();
			
			PreparedStatement statement=connection.prepareStatement("Insert into EMPLOYEESCOGNIZANT VALUES (?,?,?,?)");
			statement.setInt(1, emp);
			statement.setString(2, emp_name);
			statement.setDouble(3, emp_sal);
			statement.setString(4, emp_des);
			int rows = statement.executeUpdate();
			if(rows>0)
			{
				System.out.print("Record Inserted");
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
