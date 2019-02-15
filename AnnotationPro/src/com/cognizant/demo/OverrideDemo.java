package com.cognizant.demo;

public class OverrideDemo {
	
	class Super{
		public void x()
		{
			System.out.println("--super implementation--");
		}
	}
	class Sub extends Super{
		
		@Override
		public void x()
		{
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
