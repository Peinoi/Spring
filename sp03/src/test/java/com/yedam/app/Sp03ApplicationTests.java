package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest // jUnit 환경에서도 IoC 컨테이너를 사용 가능
class Sp03ApplicationTests {

	@Autowired // 필드 주입, 테스트 환경에서만 사용.
	private EmpMapper empMapper;

//	@Test
//	void contextLoads() {
//		assertNotNull(empMapper);
//	}

	// 전체 조회
//	@Test
//	void selectAll() {
//		List<EmpVO> list = empMapper.selectEmpAll();
//		for (EmpVO emp : list) {
//			System.out.println(emp);
//		}
//		// 결과가 몇개인지 확인이 불가하니 결과가 있는 지 없는지를 판단
//		assertFalse(list.isEmpty());
//
//	}

//	// 단건 조회
//	@Test
//	void selectOne() {
//		EmpVO empVO = new EmpVO();
//		empVO.setEmployeeId(100);
//		EmpVO findVO = empMapper.selectEmp(empVO);
//		System.out.println(findVO);
//		assertEquals("King", findVO.getLastName()); // 예상 값, 실제값
//	}

	// 등록
//	@Test
//	void insertOne() {
//		EmpVO empVO = new EmpVO();
//		empVO.setLastName("Hong");
//		empVO.setHireDate(new Date());
//		empVO.setEmail("KDhONG@google.com");
//		empVO.setJobId("IT_PROG");
//
//		int result = empMapper.insertEmp(empVO);
//		assertEquals(1, result);
//	}

	// 수정
//	@Test
//	void updateOne() {
//		EmpVO empVO = new EmpVO();
//		empVO.setLastName("Kang");
//		empVO.setHireDate(new Date());
//		int result = empMapper.updateEmp(435, empVO);
//		assertEquals(1, result);
//	}

	// 삭제
	@Test
	void deleteOne() {
		int result = empMapper.deleteEmp(435);
		assertEquals(1, result);
		
	}

}
