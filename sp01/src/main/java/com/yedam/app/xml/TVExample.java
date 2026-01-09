package com.yedam.app.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVExample {
	public static void main(String[] args) {
		System.out.println("Spring XML 방식");
		ApplicationContext ctx = //
				new GenericXmlApplicationContext("classpath:xmlApplicationContext.xml");
		TV tv = ctx.getBean(TV.class);
		tv.powerOn();
		tv.volumeUp();
		tv.powerOff();
		
		// id를 주는 방식 반환 타입은 오브젝트
//		TV lg = (TV) ctx.getBean("lg");
//		lg.powerOn();
//		lg.volumeUp();
//		lg.powerOff();
	}
}
