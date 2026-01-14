package com.yedam.app.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // web과 관련된 Bean 등록
			// Route = EndPoint (Http Method + URI)
			// + Service
			// + Return Type( View or Data )
public class URLController {

//	@RequestMapping(path = "get", method = RequestMethod.GET)
	@GetMapping("get")
	@ResponseBody // AJAX
	public String getMapping(String keyword) {
		return "Get Mehtod : keyword, " + keyword;
	}

//	@RequestMapping(path ="keyword", method=RequestMethod.POST)
	@PostMapping("post")
	@ResponseBody
	public String postMethodName(String keyword) {
		return "Post Mehtod : keyword, " + keyword;
	}

}
