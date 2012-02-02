package com.elace.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DemoController {
	
	@RequestMapping("/hello")
	public String show(){
		System.out.println("hh");
		return "helloworld";
	}
}
