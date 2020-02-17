package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		//load the spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext ("beanScope-applicationContext.xml");
		
		// retrieve bean from spring container
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("Pointing to the same objcet: " + result);
		
		System.out.println("Memory loacation for the Coach: " + theCoach);
		System.out.println("Memory loacation for the alphaCoach: " + alphaCoach);
		
		context.close();
	}

}
