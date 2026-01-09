package com.yedam.app.common;

public class TVExample {
	public static void main(String[] args) {
		// 인스턴스에 따라 결과가 달라진다.
		System.out.println("java의 일반적인 방식");
		TV tv = new SamsunTV();
		tv.powerOn();
		tv.volumeUp();
		tv.powerOff();

		tv = new LGTV();
		tv.powerOn();
		tv.volumeUp();
		tv.powerOff();

	}
}
