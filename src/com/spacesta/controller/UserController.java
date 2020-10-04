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
	@RequestMapping(path = "/adduser", method = RequestMethod.POST)
	
	public ModelAndView addUser(@Valid@ModelAttribute("user") User user, BindingResult result)
	{
		if(result.hasErrors())
		{
		 return new ModelAndView("addUser", "user", user);
		}
		else
		{
		return new ModelAndView("displayUsers","user",user);	
		}
	}
	
	@RequestMapping(path ="/add", method = RequestMethod.GET)
 public ModelAndView displayForm() {
	 return new ModelAndView("header", "user", new User());
 }
	

 
}