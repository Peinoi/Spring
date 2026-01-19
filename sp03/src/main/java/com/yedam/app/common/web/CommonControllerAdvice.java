package com.yedam.app.common.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // 모든 Controller에 공통적으로 적용
public class CommonControllerAdvice {
	@ModelAttribute("contextPath") // 모든 Page에 공통적으로 사용하는 변수
	public String contextPath(HttpServletRequest requeset) {
		return requeset.getContextPath();
	}

}
