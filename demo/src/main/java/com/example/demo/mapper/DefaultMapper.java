package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.User;

@Mapper           //언어 다른걸 맞춰줘
public interface DefaultMapper {
	public List<User> selectUserList();  //추상메소드     얘 이름이 xml에서 id  xml이 얘를 구현화
}			//셀렉트 결과가 여러개라 리스트로...       
