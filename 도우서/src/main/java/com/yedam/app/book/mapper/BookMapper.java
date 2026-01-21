package com.yedam.app.book.mapper;

import java.util.List;

import com.yedam.app.book.service.BookVO;
import com.yedam.app.book.service.RentVO;

public interface BookMapper {
	// 도서 목록 조회
	public List<BookVO> bookList();

	// 대여 목록 조회
	public List<RentVO> rentList();
	
	// 도서 번호 가져오기
	public int bookNum();
	
	
	// 도서 대여 현황 조회
	
	// 도서 등록
	public int bookInsert(BookVO bookVO);
}
