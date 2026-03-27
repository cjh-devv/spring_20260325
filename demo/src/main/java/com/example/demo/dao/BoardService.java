package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.BoardMapper;
import com.example.demo.model.Board;

@Service
public class BoardService {
@Autowired
BoardMapper boardMapper;
	public HashMap<String, Object> getBoardList(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();	
		
		try {
			List<Board> list = boardMapper.selectBoardList(map);
			resultMap.put("list", list);   // 뒤 list는 셀렉트로 받아온 데이터 담은 저 위 list
			resultMap.put("message", "데이터 조회 성공");
			resultMap.put("result", "success");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			resultMap.put("message", "서버 에러 발생!");
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	
}
