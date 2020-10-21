package com.spacesta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HomeController {

	@RequestMapping("/")
	public ModelAndView home()
	{
		return new ModelAndView("home");
		
	}
	
	@RequestMapping("/home")
	public ModelAndView homeMap()
	{
		return new ModelAndView("home");
		
	}
}
