package com.yedam.app.board.service;

import java.util.Date;

import lombok.Data;

@Data	// @Getter/Setter/ToString/EqualsAndHashCode/NoArgsConstrctor
public class BoardVO {
	private int bno;
	private String title;
	private String contents;
	private String writer;
	private Date regdate;
	private Date updatedate;
	private String image;
}
