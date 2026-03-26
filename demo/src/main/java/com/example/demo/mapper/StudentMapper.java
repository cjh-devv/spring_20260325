package com.example.demo.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Student;

@Mapper
public interface StudentMapper {
	public List<Student> selectStudentList();
	
	public int deleteStudent(HashMap<String, Object> map);  //안의 맵은 xml에서 파라미터 해시맵이라
}
