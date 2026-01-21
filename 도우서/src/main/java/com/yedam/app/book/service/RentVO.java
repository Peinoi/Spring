package com.yedam.app.book.service;

import java.util.Date;

import lombok.Data;

@Data
public class RentVO {
	private Integer bookNo;
	private String bookName;
	private Integer price;
	private Integer cnt;
}
