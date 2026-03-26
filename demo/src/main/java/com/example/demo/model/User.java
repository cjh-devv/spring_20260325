package com.example.demo.model;

import lombok.Data;

@Data
public class User {
	String userId;
	String userName;
	String pwd;
	String gender;			//변수이름 컬럼이름 같아야 맵핑가능 근데 대소문자 구분안해!
}
