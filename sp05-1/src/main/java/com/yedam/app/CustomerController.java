package com.yedam.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired
	CustomerRepository repository;

	@GetMapping("/")
	public Iterable<Customer> list() {
		return repository.findAll();

	}

	@GetMapping("/find")
	public Iterable<Customer> listname(String name) {
		return repository.findByFirstNameLike(name+"%");

	}
}
