package com.yedam.app.common.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.common.sercive.UserVO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class ParameterController {

	// QueryString(질의 문자열)
	// format : key=value&key=value&...
	// Conrtent-tyee : application/x-ww-form-urlencoded;

	// 1 => 커맨드 객체 : 2 엾음, 객체 타입
	@RequestMapping("comobj")
	@ResponseBody
	public String commandObject(UserVO user) {
		log.info("path: /combj");
		log.info("= name : " + user.getName());
		log.info("= age : " + user.getAge());
		log.info(user.toString());
		return "home";
	}

	// => 2) @RequestParam : @ 존재(default). 기본 데이터형(단일값을 처리가능한 클래스 string클래스와
	// wrapper클래스의 총칭)
	// 매개변수앞에 @RequestParam이 붙으면 필수 입력값이 된다.
	// @RequestParam에서 value의 msg는 리퀘스트 할때 이름을 msg로 하고 보내야지 값이 제대로 전달된다.
	@RequestMapping("reparm")
	@ResponseBody
	public String reparm(@RequestParam String name, Integer age,
			@RequestParam(defaultValue = "No message", value = "msg") String message) {
		log.info("path: /reparm");
		log.info("= name : " + name);
		log.info("= age : " + age);
		log.info("= message : " + message);
		return "home";
	}

	
	// URI에 값을 포함
	// Content-type : 모든 경우 가능
	// Http Method : 모두 가능
	// @PathVariable : @ 반드시 사용, 기본 데이터형(단일값)
	@RequestMapping("pathVal/{name}")
	@ResponseBody
	public String pathVariable(@PathVariable String name) {
		log.info("path : /path/{name}");
		log.info("= name : "+ name);
		return "home";
	}
	
	
	// JSON
	// format : { "key" : "value" }
	// 			or []
	// Content-type : application/x-www-form-urlencoded
	// Http Method : 전부 가능
	// @RequestBody : @  반드시 사용, 객체 or 배역(list 포함)
	@PostMapping("resbody")
	@ResponseBody
	public Map<String, Object> requestBody(@RequestBody UserVO user){
		Map<String, Object> map = new HashMap<>();
		map.put("phath", "resbody");
		map.put("data", user);
		return map;
	}
	
	
}
