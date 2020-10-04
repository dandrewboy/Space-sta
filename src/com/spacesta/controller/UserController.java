package com.spacesta.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spacesta.model.User;

@Controller

@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(path ="/register", method = RequestMethod.GET)
 public ModelAndView displayRegister() {
	 return new ModelAndView("register", "user", new User());
 }
@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView displayLogin()
	{
		return new ModelAndView("login", "user", new User());
	}
@RequestMapping(path ="/processlogin", method = RequestMethod.POST) 
public ModelAndView Register(@Valid@ModelAttribute("user") User user, BindingResult result) {
	if(result.hasErrors())
	{
	return new ModelAndView("register", "user", user);	
	}
	else
	{
		return new ModelAndView("loginSuccess", "user", user);
	}
}
@RequestMapping(path = "/processregister", method = RequestMethod.POST)
public ModelAndView Login(@Valid@ModelAttribute("user") User user, BindingResult result) {
	if(result.hasErrors())
	{
		return new  ModelAndView("register", "user", user);
	}
	else
	{
		return new ModelAndView("registerSuccess", "user", user);
}
	
}

	

 
}