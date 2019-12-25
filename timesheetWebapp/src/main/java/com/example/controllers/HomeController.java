package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.PersonDao;
import com.example.services.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
//	Send a JESON String to JAVASCRIPT(home.js)
	@RequestMapping(value= "/ldapUserdata")
	public @ResponseBody String ldapUseailsrDet(HttpSession session) throws JsonProcessingException {
		String userName =(String) session.getAttribute("uname");
//		System.out.println(userName);
		List<PersonDao> obj = new ArrayList<>();
		obj = personService.getPersonNamesByLastName(userName);
		ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        return jsonInString;
	}
}
