package com.oauth2.study.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.oauth2.study.dto.UserVO;
import java.util.Map;

@Controller
public class MainController {
	
	@RequestMapping(value="/")
	public String index(HttpSession session, HttpServletRequest request, Model model) {
		
		if (request.getSession(false)==null) {
			System.out.println("session 생성!");
			session = request.getSession();
		} else if (session.getAttribute("login")!=null) {
			System.out.println("로그인 상태!");
			model.addAttribute("userName", session.getAttribute("userName")); 
		} 
		
		System.out.println("login : " + session.getAttribute("login"));
		System.out.println("state : " + session.getAttribute("state"));
		System.out.println("userName : " + session.getAttribute("userName"));
		System.out.println("userCode : " + session.getAttribute("userCode"));
		
		return "index";
	}
}
