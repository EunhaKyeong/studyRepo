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
			System.out.println("session ����!");
			session = request.getSession();
			session.setAttribute("login", 0);
		} else if (session.getAttribute("login")==null) {
			System.out.println("session�� �ִµ� login �Ӽ��� �������� ����");
			session.setAttribute("login", 0);
		} else if (session.getAttribute("login").equals(1)&&flashMap!=null){
			System.out.println("�� ó�� �Ҽȷα���");
			this.userInfo = (UserVO) flashMap.get("user");
			model.addAttribute("userName", this.userInfo.getUserName()); 
		} else if (session.getAttribute("login").equals(1)&&flashMap==null) {
			System.out.println("�Ҽȷα��� �� ���ΰ�ħ");
			model.addAttribute("userName", this.userInfo.getUserName()); 
		} else {
			System.out.println("�α׾ƿ� or �α��� ��");
			this.userInfo = null;
		}
		
		System.out.println("index : " + session.getAttribute("login"));
		System.out.println("state : " + session.getAttribute("state"));
		return "index";
	}
}
