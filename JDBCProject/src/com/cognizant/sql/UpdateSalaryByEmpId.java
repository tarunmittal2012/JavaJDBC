package com.cognizant.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateSalaryByEmpId {

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
			System.out.println("Enter new Salary:");
			double emSal=sc.nextDouble();
			PreparedStatement statement=connection.prepareStatement("UPDATE EMPLOYEESCOGNIZANT Set emp_salary=? where emp_id=?");
			statement.setDouble(1, emSal);
			statement.setInt(2, empId);
			int rows = statement.executeUpdate();
			if(rows>0)
			{
				System.out.print("Record Updated");
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
