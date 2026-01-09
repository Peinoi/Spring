package com.yedam.app.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class RestaurantExample {
	public static void main(String[] args) {
		System.out.println("Spring XML 방식 : DI");
		ApplicationContext ctx = //
				new GenericXmlApplicationContext("classpath:xmlApplicationContext.xml");
		Restaurant res = ctx.getBean(Restaurant.class);
		res.run();
		
		// 생성자 인젝션을 더 권장
		// => 생성자를 통해 DI 이후 Bean을 교체할 수 없음
		// 세터 인젝션을 이용할 경우 아래 코드처럼 의도치않게 교체 가능
		res.setChef(new Chef());
		res.run();
		
		
	}
}
