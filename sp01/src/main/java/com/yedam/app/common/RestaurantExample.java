package com.yedam.app.common;

public class RestaurantExample {
	public static void main(String[] args) {
		System.out.println("일반적인 방식");
		Chef chef = new Chef();
		// 생성자
		Restaurant res = new Restaurant(chef);
		res.run();
		
		// 세터
		Restaurant sec = new Restaurant();
		sec.setChef(chef);
		sec.run();
	}
}
