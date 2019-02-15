package com.cognizant.demo;

import java.util.Date;

public class DeprecatedDemo {

	@Deprecated
	/**
	 * New method xNew() has been launched 
	 * use xNew() instead of x
	 */
	public void x()
	{
		System.out.println("--x--");
	}
	
	public void xNew()
	{
		System.out.println("--xNew--");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date date=new Date();
		
	}

}
