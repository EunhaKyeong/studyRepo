package com.oauth2.study.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oauth2.study.auth.SNSLogin;
import com.oauth2.study.auth.SnsUrls;
import com.oauth2.study.auth.SnsValue;

@Controller
public class LoginController {
	@Inject
	private SnsValue naverSns;	//servlet-context에 id값을 naverSns로 한 빈 주입.
	
	@RequestMapping("/login")
	public String login(Model model) {
		SNSLogin snsLogin = new SNSLogin(naverSns);
		model.addAttribute("NAVER_AUTH", snsLogin.getNaverAuthURL());
		
		return "login";
	}
}
