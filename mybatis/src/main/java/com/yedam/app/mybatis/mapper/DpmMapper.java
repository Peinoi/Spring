package com.yedam.app.mybatis.mapper;

import java.util.List;

import com.yedam.app.mybatis.service.DpmVO;

public interface DpmMapper {
	// 전체 조회
	public List<DpmVO> dselectAll();

	// 단건 조회
	public DpmVO dselectInfo(DpmVO dpm);

	// 등록
	public int dinsertInfo(DpmVO dpm);

	// 수정
	public int dupdateInfo(DpmVO dpm);

	// 삭제
	public int ddeleteInfo(int id);
}
