package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import board.controller.BoardController;

//@ComponentScan(basePackages = {"board.controller"})
@ComponentScan(basePackages = {"com.example.demo.controller","board.controller"})
@SpringBootApplication
public class Chapter01HelloGradleApplication {

	public static void main(String[] args) {
//		SpringApplication.run(Chapter01HelloGradleApplication.class, args);
		
		SpringApplication springApplication = new SpringApplication(Chapter01HelloGradleApplication.class);
		springApplication.setWebApplicationType(WebApplicationType.NONE);
		springApplication.run(args);
		
		System.out.println("gradle project");
		
	}

}
