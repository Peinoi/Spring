package com.yedam.app.common;

public class SamsunTV implements TV {

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("삼성 TV를 켭니다.");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("삼성 TV의 소리를 키웁니다..");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("삼성 TV를 끕니다.");
	}

}
