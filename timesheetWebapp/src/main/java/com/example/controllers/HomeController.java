package com.example.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/home")
	public String homeController( HttpSession session ){
		System.out.println(session.getAttribute("uaname"));
		if (session != null)
		 System.out.println(session);
		 
		return "home";
	}
}
