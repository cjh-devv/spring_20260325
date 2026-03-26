package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.DefaultMapper;
import com.example.demo.model.User;

@Service
public class DefaultService {
	@Autowired
	DefaultMapper defaultMapper;
	
	public HashMap<String, Object> getUserList(){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<User> list = defaultMapper.selectUserList();
		
		resultMap.put("list", list);   // 뒤 list는 셀렉트로 받아온 데이터 담은 저 위 list
		resultMap.put("message", "데이터 조회 성공");
		resultMap.put("result", "success");
				
		return resultMap;
	}
}
