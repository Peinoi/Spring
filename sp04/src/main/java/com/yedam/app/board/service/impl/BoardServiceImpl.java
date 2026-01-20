package com.yedam.app.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardMapper boardMapper;
//
//	public BoardServiceImpl(BoardMapper boardMapper) {
//		this.boardMapper = boardMapper;
//	}

	// 게시글 전체 조회
	@Override
	public List<BoardVO> findAll() {
		return boardMapper.selectAll();
	}

}
