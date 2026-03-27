package com.example.demo.model;

import lombok.Data;

@Data
public class Board {      //보드 테이블에 있는 컬럼을 넣어
	int boardNo;
	String userId;
	String title;
	String contents;
	int cnt;
	int kind;
	String cDateTime;
	String uDateTime;
}
