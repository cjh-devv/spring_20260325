package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.DefaultService;
import com.google.gson.Gson;

@Controller
public class DefaultController {

	@Autowired   //서버실행될때 아래 객체 만들어서 돌려써라
	DefaultService defaultService;   
	
	@RequestMapping("/default.do")   //url 과 특정 컨트롤러 메서드와 연결(매핑)???
	public String test(Model model) throws Exception{
		return "/default";          // .jsp 파일을 실행하겠다
	}
	
	@RequestMapping("/test.do")	
	public String test2(Model model) throws Exception{
		return "/test";				// .jsp 파일을 실행하겠다
	}
	
	@RequestMapping(value = "/default.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody		//데이터돌려줘    이거있는애는 독스로
	public String login(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		return new Gson().toJson(resultMap); 
	}
	@RequestMapping(value = "/test.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String test(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		//DefaultService obj = new DefaultService();  //진짜 한번만 쓰고 말때
		resultMap = defaultService.getUserList();			
		
		return new Gson().toJson(resultMap); 
	}
}
