package com.yedam.app.book.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;
import com.yedam.app.book.service.RentVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {

	private final BookService bookService;

	// 첫페이지
	@GetMapping("book")
	public String book() {
		return "book/bookHome";
	}

	// 도서 목록
	@GetMapping("bookList")
	public String bookList(Model model) {
		List<BookVO> findVO = bookService.findAll();
		model.addAttribute("list", findVO);
		return "book/list";
	}
	
	// 렌트 목록
	@GetMapping("rentList")
	public String rentList(Model model) {
		List<RentVO> findVO = bookService.rentFind();
		model.addAttribute("list", findVO);
		return "book/rent";
	}
	
	// 등록 - 페이지
	@GetMapping("bookInsert")
	public String bookInsertForm(Model model) {
		int num = bookService.findMaxNum();
		model.addAttribute("num", num);
		return "book/insert";
	}

	// 등록 - 처리
	@PostMapping("bookInsert")
	public String bookInsertProcess(BookVO bookVO) {
		int reslut = bookService.addInfo(bookVO);
		return "book/bookHome";
	}
}
