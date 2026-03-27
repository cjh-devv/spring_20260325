package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.BoardService;
import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;

	@Controller
	public class BoardController {
	@Autowired
	BoardService boardService;

	@RequestMapping("/board/list.do")   //url 과 특정 컨트롤러 메서드와 연결(매핑)???
	public String test(Model model) throws Exception{
		return "/board/board-list";          // .jsp 파일을 실행하겠다
	}
	@RequestMapping("/board/board-add.do")   //url 과 특정 컨트롤러 메서드와 연결(매핑)???
	public String add(Model model) throws Exception{
		return "/board/board-add";          // .jsp 파일을 실행하겠다
	}
	@RequestMapping("/board/view.do")   //url 과 특정 컨트롤러 메서드와 연결(매핑)???
	public String view(HttpServletRequest request,@RequestParam HashMap<String, Object> map) throws Exception{
		System.out.println(map);
		request.setAttribute("boardNo", map.get("boardNo"));
		return "/board/board-view";          // .jsp 파일을 실행하겠다
	}
	@RequestMapping("/board/edit.do")   //url 과 특정 컨트롤러 메서드와 연결(매핑)???
	public String edit(HttpServletRequest request,@RequestParam HashMap<String, Object> map) throws Exception{
		System.out.println(map);
		request.setAttribute("boardNo", map.get("boardNo"));
		return "/board/board-edit";          // .jsp 파일을 실행하겠다
	}

	@RequestMapping(value = "/board/list.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String list(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		//DefaultService obj = new DefaultService();  //진짜 한번만 쓰고 말때
		resultMap = boardService.getBoardList(map);			
		
		return new Gson().toJson(resultMap); 
	}
	@RequestMapping(value = "/board/add.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String add(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		System.out.println(map);
		//DefaultService obj = new DefaultService();  //진짜 한번만 쓰고 말때
		resultMap = boardService.addBoard(map);			
		
		return new Gson().toJson(resultMap); 
	}
	@RequestMapping(value = "/board/info.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String info(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		System.out.println(map);
		//DefaultService obj = new DefaultService();  //진짜 한번만 쓰고 말때
		resultMap = boardService.getBoard(map);			
		
		return new Gson().toJson(resultMap); 
	}
	@RequestMapping(value = "/board/edit.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String edit(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		System.out.println(map);
		//DefaultService obj = new DefaultService();  //진짜 한번만 쓰고 말때
		resultMap = boardService.editBoard(map);			
		
		return new Gson().toJson(resultMap); 
	}
}
