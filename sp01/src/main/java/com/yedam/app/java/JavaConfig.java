package com.yedam.app.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Java base의 설정파일
public class JavaConfig {
	@Bean // Spring이 관리할 Bean 등록
	public Chef chef() {
		return new Chef();
	}

	@Bean
	// 빈을 받아올려고 매개변수를 받음
	public Restaurant restaurant(Chef chef) {
		Restaurant res = new Restaurant(chef);
		return res;
	}
}
