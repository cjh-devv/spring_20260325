package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;

@Service
public class StudentService {
	@Autowired
	StudentMapper studentMapper;
	
	public HashMap<String, Object> getStudentList(){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<Student> list = studentMapper.selectStudentList();
		
		resultMap.put("list", list);
		resultMap.put("message", "조회성공");
		resultMap.put("result", "seccess");
		return resultMap;
	}
	public HashMap<String, Object> removeStudentList(HashMap<String, Object> map){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		int cnt = studentMapper.deleteStudent(map);
		if(cnt>0) {
			resultMap.put("message", "삭제성공");
		}else {
			resultMap.put("message", "삭제실패");
		}
		resultMap.put("result", "seccess");
		
		return resultMap;
	}
}
