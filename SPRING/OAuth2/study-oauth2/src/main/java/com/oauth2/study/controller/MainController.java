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
	private UserVO userInfo;
	
	@RequestMapping(value="/")
	public String index(HttpSession session, HttpServletRequest request, Model model) {
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		
		if (request.getSession(false)==null) {
			System.out.println("session 생성!");
			session = request.getSession();
			session.setAttribute("login", 0);
		} else if (session.getAttribute("login")==null) {
			System.out.println("session은 있는데 login 속성이 존재하지 않음");
			session.setAttribute("login", 0);
		} else if (session.getAttribute("login").equals(1)&&flashMap!=null){
			System.out.println("맨 처음 소셜로그인");
			this.userInfo = (UserVO) flashMap.get("user");
			model.addAttribute("userName", this.userInfo.getUserName()); 
		} else if (session.getAttribute("login").equals(1)&&flashMap==null) {
			System.out.println("소셜로그인 후 새로고침");
			model.addAttribute("userName", this.userInfo.getUserName()); 
		} else {
			System.out.println("로그아웃 or 로그인 전");
			this.userInfo = null;
		}
		
		System.out.println("index : " + session.getAttribute("login"));
		System.out.println("state : " + session.getAttribute("state"));
		return "index";
	}
}
