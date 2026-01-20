package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

@RestController // @Controller + @ResponseBody
@RequiredArgsConstructor
public class empRestController {
	private final EmpService empSevirce;

	// 전체 조회 :Get emps
	@GetMapping("emps")
	public List<EmpVO> empList() {
		return empSevirce.findAll();
	}

	// 단건 조회 :Get emps/{eid}
	// 기본적으로 패스배리어블과 이름이 동일해야한다.
	// 리퀘스트 파람으로 바꿔도 되긴 함
	@GetMapping("emps/{eid}")
	public EmpVO empInfo(@PathVariable Integer eid) {
		// 빌드 패턴
		// 생성자 선택을 빌더가 함 매개변수 차가하고 싶으면 .매개변수 로 추가 하고 마지막에 .build()로 마무리
		EmpVO empVO = EmpVO.builder().employeeId(eid).build();
		return empSevirce.findByEmployeeId(empVO);
	}

	// 등록 : POST :emps + json
	@PostMapping("emps") // @RequestBody : JSON
	public int empInsert(@RequestBody EmpVO empVO) {
		return empSevirce.addEmpInfo(empVO);
	}

	// 수정 : PUT emps/{eid}
	@PutMapping("emps/{eid}")
	public Map<String, Object> empUpdate(
			// 경로를 통해서 수정할 Target(대상)
			@PathVariable(name = "eid") Integer employeeId,
			// 수정할 정보는 JSON 포멧으로
			@RequestBody EmpVO empVO) {
	
		empVO.setEmployeeId(employeeId);
		return empSevirce.modifyEmpInfo(empVO);
	}

	// 삭제 : DELETE emps/{eid}
	@DeleteMapping("emps/{employeeId}")
	public Map<String, Object> empDelete(@PathVariable Integer employeeId) {
		return empSevirce.removeEmpInfo(employeeId);

	}
}
