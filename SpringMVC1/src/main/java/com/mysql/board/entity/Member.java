package com.mysql.board.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //- Lombok API
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private int num;
	private String id;
	private String pw;
	private String email;
}
