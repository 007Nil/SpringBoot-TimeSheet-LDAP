package com.example.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.PersonDao;
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
			return "home";
		}

	}
	@RequestMapping(value= "/ldapUserdata")
	public @ResponseBody List<PersonDao> ldapUseailsrDet(HttpSession session) {
		String userName =(String) session.getAttribute("uname");
		System.out.println("Hit");
		return personService.getPersonNamesByLastName(userName);
	}
}
