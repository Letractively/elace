package com.elace.demo.web;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.elace.common.bean.User;
import com.elace.common.service.UserService;


@Controller
public class DemoController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/hello")
	public ModelAndView show(){
		Long userId = 1L;
		User user = userService.getUserById( userId );
		ModelAndView modelAndView = new ModelAndView("helloworld");
		Map dataModel = new LinkedHashMap();
		dataModel.put("user", user);
		modelAndView.addAllObjects( dataModel );
		return modelAndView;
	}
}
