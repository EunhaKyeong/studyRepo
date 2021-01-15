package com.oauth2.study.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.oauth2.study.auth.SNSLogin;
import com.oauth2.study.auth.SnsValue;
import com.oauth2.study.dto.UserVO;
import com.oauth2.study.service.TestServiceImpl;

@Controller
public class LoginController {
	@Inject
	private SnsValue naverSns;	//servlet-context�� id���� naverSns�� �� �� ����.
	
	@Inject TestServiceImpl testService;
	
	//�α��� ������
	@RequestMapping("/login")
	public String login(Model model) {
		SNSLogin snsLogin = new SNSLogin(naverSns);
		model.addAttribute("NAVER_AUTH", snsLogin.getNaverAuthURL());
		
		return "login";
	}
	
	//login callback
	@RequestMapping(value="/auth/{service}/callback", method=RequestMethod.GET)
	public String loginCallback(Model model, @PathVariable String service, @RequestParam String code, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
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
		
		if (isUser==1) {	//4-1. ������ ����ڸ� �����α��� ��Ű�� Ȩ���� �̵�.
			session.setAttribute("userId", user.getUserId());
			redirectAttributes.addFlashAttribute("user", user);
			
			return "redirect:/";
		}
		else {	//4-2. �̰����̸� ȸ������ �������� �̵�.
			redirectAttributes.addFlashAttribute("user", user);	//�̰����� �⺻������ ������
			
			return "redirect:/signUp";	//signUp ������(ȸ������ ������)�� �����̷�Ʈ
		}
	}
	
	//ȸ������
	@RequestMapping(value="/signUp", method=RequestMethod.GET)
	public String signUpGet(HttpServletRequest request, Model model) {
		System.out.println("signUp-GET");
		
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		UserVO userInfo = (UserVO) flashMap.get("user");
		
		model.addAttribute("user", userInfo);
		
		return "signUp";
	}
	
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	public String signUpPost(UserVO newUser) {
		System.out.println("signUp-POST");

		testService.insertUser(newUser);
		
		return "signUp";
	}
	
	//�α׾ƿ�
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
}
