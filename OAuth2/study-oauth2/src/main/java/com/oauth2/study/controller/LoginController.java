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

@Controller
public class LoginController {
	@Inject
	private SnsValue naverSns;	//servlet-context�� id���� naverSns�� �� �� ����.
	
	@RequestMapping("/login")
	public String login(Model model) {
		SNSLogin snsLogin = new SNSLogin(naverSns);
		model.addAttribute("NAVER_AUTH", snsLogin.getNaverAuthURL());
		
		return "login";
	}
	
	//login callback
	@RequestMapping(value="/auth/{service}/callback", method=RequestMethod.GET)
	public String loginCallback(Model model, @PathVariable String service, @RequestParam String code) throws Exception {
		//1. �α����� �����ϸ� access Token�� �ޱ� ���� code�� ����.
		//2. access Token�� �̿��� ����� ������ ������ ����.
		SNSLogin sns = null;
		if (service.equals("naver"))
			sns = new SNSLogin(naverSns);
		String profile = sns.getProfile(code);	//������ ���� ������
		System.out.println(profile);
		model.addAttribute("profieResult", profile);	//���������� view�� �����ֱ�
		
		//3. ����� �����ʰ� �츮�� User ���̺��� ���� ������ ��������� Ȯ��.
		//4-1. ������ ����ڸ� �����α��� ��Ű�� Ȩ���� �̵�.
		//4-2. �̰����̸� ȸ������ �������� �̵�.
		return "loginResult";
	}
}
