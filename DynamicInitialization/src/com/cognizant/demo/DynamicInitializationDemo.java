package com.cognizant.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DynamicInitializationDemo {

	public static void main(final String args[])
	{
		//static Intialization
		final MyClass myClass=new MyClass();
		myClass.x(100,200);
		//dynamic Intialization
		final Class<MyClass> classData=MyClass.class;
		//Reflection API
		try {
				Constructor<MyClass> constructor  = classData.getConstructor();
				final MyClass mc1= constructor.newInstance();
					Method method1=classData.getMethod("x", int.class,int.class);
					method1.invoke(mc1,new Object[]{30,40});
					//Alternative
					System.out.println("Method3");
				final MyClass mc2= (MyClass) Class.forName("com.cognizant.demo.MyClass").newInstance();
					method1.invoke(mc2, new Object[]{30,10});
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
	}
}
