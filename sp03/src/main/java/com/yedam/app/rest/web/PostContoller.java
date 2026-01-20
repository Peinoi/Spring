package com.yedam.app.rest.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yedam.app.rest.service.Post;

@RestController
public class PostContoller {
	@GetMapping("selectOne")
	public Map<String, Object> selectOne() {
		Map<String, Object> map = new HashMap<>();
		RestTemplate restTemplate = new RestTemplate();

		String url = "https://jsonplaceholder.typicode.com/posts/1";
		Post post = restTemplate.getForObject(url, Post.class);
		map.put("result", post);
		return map;
	}

	@GetMapping("insertOne")
	public Map<String, Object> insertOne() {
		Map<String, Object> map = new HashMap<>();
		RestTemplate restTemplate = new RestTemplate();

		String url = "https://jsonplaceholder.typicode.com/posts";
		Post newPost = new Post();
		newPost.setUserId(101);
		newPost.setTitle("New Title");
		newPost.setBody("New Content");
		Post post = restTemplate.postForObject(url, newPost, Post.class);

		map.put("result", post);
		return map;
	}
}
