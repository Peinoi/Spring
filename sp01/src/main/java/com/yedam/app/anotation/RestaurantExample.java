package com.yedam.app.anotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class RestaurantExample {
	public static void main(String[] args) {
		System.out.println("Spring anotation 방식 : DI");
		ApplicationContext ctx = //
				new GenericXmlApplicationContext("classpath:anotationApplicationContext.xml");
		Restaurant res = ctx.getBean(Restaurant.class);
		res.run();
		

		
		
	}
}
