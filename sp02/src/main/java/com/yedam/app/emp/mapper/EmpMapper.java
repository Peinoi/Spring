package com.yedam.app.emp.mapper;

import java.util.List;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	// 전체 조회
	public List<EmpVO> selectAll();
	
	// 단건 조회
	public EmpVO selectInfo(int no);
}
