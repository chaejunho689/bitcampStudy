package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloController {

	public HelloController() {
		System.out.println("Hello Controller 생성자");
	}
	
	@RequestMapping(value="/")
//	@ResponseBody//브라우저에 바로 문자열을 뿌리기
	//브라우저에 바로 문자열을 뿌리기 
	public String index() {
		return "Hello Spring boot";
	}
	
	@RequestMapping(value="/hello")
	public String hello(@RequestParam(value="name") String name) {
		return "안녕하세요. " + name + "님!!";
	}
	
}
