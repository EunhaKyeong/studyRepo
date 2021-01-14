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
	private SnsValue naverSns;	//servlet-context�� id���� naverSns�� �� �� ����.
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
		//1. �α����� �����ϸ� access Token�� �ޱ� ���� code�� ����.
		//2. access Token�� �̿��� ����� ������ ������ ����.
		//3. ����� �����ʰ� �츮�� User ���̺��� ���� ������ ��������� Ȯ��.
		SNSLogin sns = null;
		UserVO user = new UserVO();
		int isUser = 0;
		if (service.equals("naver")) {
			sns = new SNSLogin(naverSns);
			user = sns.getProfile(code);	//������ ���� ������
			isUser = testService.checkIdNaver(user.getUserId());	//������ ��������� �̰��������� Ȯ��-1�̸� ���Ի����, 0�̸� �̰�����
		}
		
		String profieResult = "";
		if (isUser==1) {	//4-1. ������ ����ڸ� �����α��� ��Ű�� Ȩ���� �̵�.
			profieResult = user.getUserName() + "�� �ݰ����ϴ�!";
		}
		else {	//4-2. �̰����̸� ȸ������ �������� �̵�.
			profieResult = "ȸ������ �������� �̵��մϴ�.";
		}
		model.addAttribute("profieResult", profieResult);
		
		return "loginResult";
	}
}
