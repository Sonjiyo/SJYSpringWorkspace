package com.mysql.basic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysql.basic.mapper.MemberMapper;

@Controller
public class HomeController {
	
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest req) {
		return req.getContextPath();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "member/index";
	}
	
	@RequestMapping(value = "member/index", method = RequestMethod.GET)
	public String index() {
		return "member/index";
	}
}
