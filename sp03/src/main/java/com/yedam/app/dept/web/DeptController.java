package com.yedam.app.dept.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;
import com.yedam.app.dept.service.impl.DeptServiceImpl;

@Controller
public class DeptController {

	private final DeptServiceImpl deptServiceImpl;
	private long id = 0;
	private final DeptService deptService;

	// 생성자
	@Autowired
	public DeptController(DeptService deptService, DeptServiceImpl deptServiceImpl) {
		this.deptService = deptService;
		this.deptServiceImpl = deptServiceImpl;
	}

	// 전체
	@GetMapping("deptList")
	public String deptList(Model model) {
		List<DeptVO> list = deptService.findAll();
		model.addAttribute("depts", list);
		return "dept/list";
	}

	// 단건 조회
	@GetMapping("deptInfo")
	public String deptInfo(DeptVO deptVO, Model model) {
		DeptVO findVO = deptService.findByDeptId(deptVO);
		model.addAttribute("dept", findVO);
		return "dept/info";
	}

	// 등록
	@GetMapping("deptInsert")
	public String deptInsertForm() {
		return "dept/insert";
	}

	// 등록 처리
	@PostMapping("deptInsert")
	public String deptInsertProcess(DeptVO deptVO) {
		int did = deptService.addDeptInfo(deptVO);
		return "redirect:deptInfo?departmentId=" + did;
	}

	// 수정
	@GetMapping("deptUpdate")
	public String UpdateForm(DeptVO deptVO, Model model) {
		DeptVO findVO = deptService.findByDeptId(deptVO);
		model.addAttribute("dept", findVO);
		return "dept/update";
	}

	// 수정 처리
	@PostMapping("deptUpdate")
	@ResponseBody
	public Map<String, Object> deptUpdateProcess(@RequestBody DeptVO deptVO) {
		return deptService.modifyDeptInfo(deptVO);
	}

	// 삭제
	@GetMapping("deptDelete")
	public String deptDelete(Integer deptId) {
		deptService.removeDeptInfo(deptId);
		return "redirect:deptList";
	}

}
