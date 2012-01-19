package com.elace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloWorldController {
	
	@RequestMapping("/hello")
	public String show(){
		return "helloworld";
	}
}
