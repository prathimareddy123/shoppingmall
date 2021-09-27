package com.boot.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.boot.shop.Model.UserRegistrationModel;
import com.boot.shop.repository.UserDao;
import com.boot.shop.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showpage(@ModelAttribute("reg") UserRegistrationModel userRegisterModel,ModelAndView model) {
		model.setViewName("register");
		return model;
	}

	@RequestMapping(value = "/store", method = RequestMethod.POST)
	public ModelAndView showregister(UserRegistrationModel userRegisterModel,ModelAndView model) {
		model.addObject(userService.storeUser(userRegisterModel, model));
		return model;
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String show(@RequestParam("email") String username,@RequestParam("password") String pwd) {
		
		return userService.dispalyStore(username,pwd);
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String show() {
		
		return "login";
	}
//	@RequestMapping(value="/profilepage",method=RequestMethod.POST)
//	public 

}
