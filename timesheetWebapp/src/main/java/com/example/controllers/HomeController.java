package com.example.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/home")
	public String homeController( HttpSession session ){
		String userName =(String) session.getAttribute("uname");
		String password = (String) session.getAttribute("passwd");
		if (userName == null|| password == null) {
			return "redirect:/login";
		}
		else
		return "home";
	}
}
