package com.yedam.app.emp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // Lombok => final field를 활용한 생성자
@Controller	//Router 역할을 하는 객체
public class EmpController {
	private final EmpService empService;

	@GetMapping("/empList")
	public String empList(Model model) {
		List<EmpVO> list = empService.findAll();
		model.addAttribute("emps", list);
		return "empList";
	}
	
	@GetMapping("/empInfo")
	@ResponseBody
	public String empListInfo(int a, Model model) {
		EmpVO list = empService.findInfo(a);
		model.addAttribute("empInfo", list);
		return "empList";
	}
}
