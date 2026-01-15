package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;
import com.yedam.app.emp.service.impl.EmpServiceImpl;

@Controller // DispacherServlet와 관련
public class EmpController {

	private final EmpServiceImpl empServiceImpl;
	private long id = 0;
	private final EmpService empService;

	@Autowired
	public EmpController(EmpService empService, EmpServiceImpl empServiceImpl) {
		this.empService = empService;
		this.empServiceImpl = empServiceImpl;
	}

	// Get : 빈페이지, 조회 (빈페이와 조회)
	// Post : 데이터 조작(등록, 수정, 삭제)

	// 전부 조회
	@GetMapping("empList") // Model = Request + Response
	public String empList(Model model) {
		// 1) 제공할 서비스 수행
		List<EmpVO> list = empService.findAll();
		// 2) 클라이언트에 전달할 데잍커 닫ㄷ기
		model.addAttribute("emps", list);
		// 3) 데이터를 출 력할 페이지 선택
		return "emp/list"; // 페이지 이동은 ' / '를 시작하면 안됨
		// prefix => classpahth:/ptmlates
		// subfix => .html

	}

	// 단건 조회
	@GetMapping("empInfo") // Get이라는 메소드 때문에 QueryString => 커맨드 객체 or @RequestParam
	public String empInfo(EmpVO empVO, Model model) {
		EmpVO findVO = empService.findByEmployeeId(empVO);
		model.addAttribute("emp", findVO);
		return "emp/info";
	}

	// 등록 - 페이지 - 페이지 때문에 get을 사용해야함
	@GetMapping("empInsert")
	public String empInsertForm() {
		return "emp/insert";
	}

	// 등록 - 처리
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) {
		int eid = empService.addEmpInfo(empVO);

		//
		return "redirect:empInfo?employeeId=" + eid;
	}

	// 수정 - 페이지 = 단건 조회
	@GetMapping("empUpdate")
	public String UpdateForm(EmpVO empVO, Model model) {
		EmpVO findVO = empService.findByEmployeeId(empVO);
		model.addAttribute("emp", findVO);
		return "emp/update";
	}

	// 수정 - 처리 = 등록을 처리하는 컨트롤러
	@PostMapping("empUpdate")
	@ResponseBody // AJAX, 순수하게 데이터만 반환
	public Map<String, Object> empUpdateProcess(@RequestBody EmpVO empVO) { // JSON
		return empService.modifyEmpInfo(empVO);
	}

	// 단건 삭제
	@GetMapping("empDelete")
	public String empDelete(Integer empId) {
		empService.removeEmpInfo(empId);
		return "redirect:empList";
	}

}
