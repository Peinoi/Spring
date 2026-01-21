package com.yedam.app.book.service;

import java.util.List;

public interface BookService {
	
	// 목록 조회
	public List<BookVO> findAll();
	
	// 대여 목록 조회
	public List<RentVO> rentFind();

	//번호 가져오기
	public int findMaxNum();
	
	// 등록
	public int addInfo(BookVO bookVO);
	
}
