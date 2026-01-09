package com.yedam.app.xml;

public class Restaurant {
	// 필드
	private Chef chef;


	// 생성자
	public Restaurant(Chef chef) {
		System.out.println("생성자 인젝션");
		this.chef = chef;
	}

	public Restaurant() {
	}

	// 메소드
	public void setChef(Chef chef) {
		System.out.println("세터 인젝션");
		this.chef = chef;
	}

	public void run() {
		chef.cooking();
	}
}
