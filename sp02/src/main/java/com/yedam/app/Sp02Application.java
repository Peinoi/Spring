package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.yedam.app.**.mapper") // Mapper의 Interface를 스캔 -> Bean으로 등록
public class Sp02Application {

	public static void main(String[] args) {
		SpringApplication.run(Sp02Application.class, args);
	}
	


}
