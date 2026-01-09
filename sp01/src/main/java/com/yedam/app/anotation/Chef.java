package com.yedam.app.anotation;

import org.springframework.stereotype.Component;

@Component	// 빈으로 등록
public class Chef {
	
	public void cooking() {
		System.out.println("요리를 합니다.");
	}

}
