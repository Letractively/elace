package com.elace.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloWorldController {
	
	@RequestMapping("/hello")
	public String show(){
		System.out.println("Helloworld!");
		return "helloworld";
	}
}
