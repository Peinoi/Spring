package com.yedam.app.board.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

import lombok.RequiredArgsConstructor;

@Controller // DispatcherServlet에게 정보를 전달
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;

	// 게시글 전체 조회
	@GetMapping("boardList")
	public String boardList(Model model) {
		// 제공할 서비스
		List<BoardVO> list = boardService.findAll();

		// 페이지에 전달할 데이터
		model.addAttribute("boards", list);

		// 사용할 페이지
		return "board/list";
	}

	// 게시글 상세 조회
	@GetMapping("boardInfo") // Query String(커맨드 객체, @RequestParam)
	public String boardInfo(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.findByBno(boardVO);
		model.addAttribute("board", findVO);
		return "board/info";
	}

	// 게시글 등록 - 페이지
	@GetMapping("boardInsert")
	public String boardInsertForm() {
		return "board/insert";
	}

	// 게시글 등록 - 처리
	@PostMapping("boardInsert") // 페이지 전환 => <form/> => QueryString => 커맨드 객체
	public String boardInsertProcess(BoardVO boardVO) {
		int bno = boardService.addInfo(boardVO);
		return "redirect:boardInfo?bno=" + bno;
	}

}
