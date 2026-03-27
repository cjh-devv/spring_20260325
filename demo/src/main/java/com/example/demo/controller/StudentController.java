package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.StudentService;
import com.google.gson.Gson;


@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/stu-list.do")   //url 과 특정 컨트롤러 메서드와 연결(매핑)???
	public String student(Model model) throws Exception{
		return "/student/stu-list";          // 폴더 경로까지 넣어줘
	}
	
	@RequestMapping("/stu-add.do")   
	public String add(Model model) throws Exception{
		return "/student/stu-add";       
	}
	
	@RequestMapping(value ="/stu-list.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String login(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap = studentService.getStudentList(map);
		return new Gson().toJson(resultMap); 
	}
	@RequestMapping(value ="/stu-remove.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String remove(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		System.out.println(map);
		resultMap = studentService.removeStudentList(map);
		return new Gson().toJson(resultMap); 
	}
	@RequestMapping(value ="/stu-check.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String check(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		System.out.println(map);
		resultMap = studentService.getStudent(map);
		return new Gson().toJson(resultMap); 
	}
	@RequestMapping(value ="/stu-add.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String add(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		System.out.println(map);
		resultMap = studentService.addStudent(map);
		return new Gson().toJson(resultMap); 
	}
}
