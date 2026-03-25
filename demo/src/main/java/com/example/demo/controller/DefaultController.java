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
	
	@RequestMapping("/default.do")
	public String test(Model model) throws Exception{
		return "/default";
	}
	
	@RequestMapping("/test.do")
	public String test2(Model model) throws Exception{
		return "/test";
	}
	
	@RequestMapping(value = "/default.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String login(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		return new Gson().toJson(resultMap); 
	}
	@RequestMapping(value = "/test.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String test(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		//DefaultService obj = new DefaultService();  //진짜 한번만 쓰고 말때
		defaultService.getUserList();			//진짜 한번만 쓰고 말때
		
		System.out.println("test.dox 호출 됨!!");
		System.out.println(map);
		
		resultMap.put("result", "success");
		resultMap.put("Hello", "World");
		return new Gson().toJson(resultMap); 
	}
	
}
