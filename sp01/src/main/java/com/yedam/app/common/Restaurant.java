package com.yedam.app.common;

public class Restaurant {
	// 필드
	private Chef chef;


	// 생성자
	public Restaurant(Chef chef) {
		this.chef = chef;
	}

	public Restaurant() {
	}

	// 메소드
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void run() {
		chef.cooking();
	}
}
