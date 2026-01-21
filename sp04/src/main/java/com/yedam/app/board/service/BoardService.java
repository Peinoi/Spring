package com.yedam.app.board.service;

import java.util.List;

public interface BoardService {

		// 전체 조회
		public List<BoardVO> findAll();
		
		// 단건 조회
		public BoardVO findByBno(BoardVO boardVO);
		
		// 등록
		public int addInfo(BoardVO boardVO); 
		
		// 수정
		
		// 삭제
}
