package com.example.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.services.PersonService;

@Controller
public class HomeController {

	@Autowired
	PersonService personService;
	
	@RequestMapping(value = "/home")
	public String homeController(HttpSession session) {
		String userName = (String) session.getAttribute("uname");
		String password = (String) session.getAttribute("passwd");
		if (userName == null || password == null) {
			return "redirect:/login";
		} else {
			System.out.println(personService.getPersonNamesByLastName(userName));
			return "home";
		}

	}
}
