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
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(path = "/login", method = RequestMethod.GET) 
	public ModelAndView displayForm() {
		return new ModelAndView("login", "user", new User());
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView loginUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		System.out.println("Username: " + user.getUsername());
		System.out.println("Password: " + user.getPassword());
		User userVal = userService.validateUser(user);

		if (result.hasFieldErrors("username") || result.hasFieldErrors("password")) {
			return new ModelAndView("login", "user", user);
		}

		else if (null != userVal) {
			return new ModelAndView("loginMessage", "message", "Welcome " + user.getUsername()+"!");
		}

		//This is temp (used for testing)
		/*else if(user.getUsername().matches("gdavis") && user.getPassword().matches("1234")) {
			return new ModelAndView("loginMessage", "message", "Welcome " + user.getUsername()+"!");
		}*/
		else {
			return new ModelAndView("loginMessage", "message", "Login Failed!");
		}
		
	}
	
}
