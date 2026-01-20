package com.yedam.app;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.aop.service.AaaService;

@SpringBootTest
public class AopTests {
	@Autowired
	AaaService aaaService;
	
	@Test
	void transcationlTest() {
		aaaService.insert();
	}
}
