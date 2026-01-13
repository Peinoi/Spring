package com.yedam.app.emp.service;

import java.util.List;

public interface EmpService {
	// 전체 조회
	public List<EmpVO> findAll();

	// 단건 조회
	public EmpVO findInfo(int no);
}
