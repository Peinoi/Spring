package com.yedam.app.book.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yedam.app.book.mapper.BookMapper;
import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;
import com.yedam.app.book.service.RentVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

	private final BookMapper bookMapper;

	// 전체 조회
	@Override
	public List<BookVO> findAll() {
		return bookMapper.bookList();
	}

	// 최대값 찾는거
	@Override
	public int findMaxNum() {

		return bookMapper.bookNum();
	}

	// 등록
	@Override
	public int addInfo(BookVO bookVO) {
		int result = bookMapper.bookInsert(bookVO);
		return result == 1 ? bookVO.getBookNo() : -1;
	}

	// 대여 목록
	@Override
	public List<RentVO> rentFind() {
		return bookMapper.rentList();
	}

}
