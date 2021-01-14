package com.oauth2.study.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oauth2.study.auth.SNSLogin;
import com.oauth2.study.auth.SnsUrls;
import com.oauth2.study.auth.SnsValue;
import com.oauth2.study.dto.UserVO;
import com.oauth2.study.service.TestServiceImpl;

@Controller
public class LoginController {
	@Inject
	private SnsValue naverSns;	//servlet-context에 id값을 naverSns로 한 빈 주입.
	@Inject TestServiceImpl testService;
	
	@RequestMapping("/login")
	public String login(Model model) {
		SNSLogin snsLogin = new SNSLogin(naverSns);
		model.addAttribute("NAVER_AUTH", snsLogin.getNaverAuthURL());
		
		return "login";
	}
	
	//login callback
	@RequestMapping(value="/auth/{service}/callback", method=RequestMethod.GET)
	public String loginCallback(Model model, @PathVariable String service, @RequestParam String code) throws Exception {
		//1. 로그인이 성공하면 access Token을 받기 위한 code를 받음.
		//2. access Token을 이용해 사용자 프로필 정보를 얻음.
		//3. 사용자 프로필과 우리의 User 테이블을 비교해 가입한 사용자인지 확인.
		SNSLogin sns = null;
		UserVO user = new UserVO();
		int isUser = 0;
		if (service.equals("naver")) {
			sns = new SNSLogin(naverSns);
			user = sns.getProfile(code);	//프로필 정보 얻어오기
			isUser = testService.checkIdNaver(user.getUserId());	//가입한 사용자인지 미가입자인지 확인-1이면 가입사용자, 0이면 미가입자
		}
		
		String profieResult = "";
		if (isUser==1) {	//4-1. 가입한 사용자면 강제로그인 시키고 홈으로 이동.
			profieResult = user.getUserName() + "님 반갑습니다!";
		}
		else {	//4-2. 미가입이면 회원가입 페이지로 이동.
			profieResult = "회원가입 페이지로 이동합니다.";
		}
		model.addAttribute("profieResult", profieResult);
		
		return "loginResult";
	}
}
