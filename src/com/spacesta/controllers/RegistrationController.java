package com.spacesta.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spacesta.models.User;
import com.spacesta.services.UserService;

@Controller
public class RegistrationController {
	@Autowired
	public UserService userService;
	
	@RequestMapping(path = "/registration", method = RequestMethod.GET) 
	public ModelAndView displayForm() {
		return new ModelAndView("registration", "user", new User());
	}
	
	@RequestMapping(path = "/registration", method = RequestMethod.POST)
	public ModelAndView addUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		System.out.println("Username: " + user.getUsername());
		System.out.println("Password: " + user.getPassword());

		if (result.hasErrors()) {
		  
			return new ModelAndView("registration", "user", user);
		}
		
		//This is temp (used for testing)
		else {
			boolean check = userService.checkRegister(user);
			if(check == false)
			{
				userService.register(user);
			}
			else
			{
				  result.rejectValue("username", "error.user", "The User already exists");
				  return new ModelAndView("registration", "user", user);
			}
			
			return new ModelAndView("login", "user", new User());
		}
		
	}
	
}
