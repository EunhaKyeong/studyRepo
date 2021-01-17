package com.oauth2.study.auth;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.oauth2.study.dto.UserVO;

//�츮�� socialloginAPI ������ scribejava�� ����� scribejava�� Ȱ���� �Ҽȷα����� ���ϰ� �� �� �ֵ��� ���ִ� �۾�.
@Service
public class SNSLogin {
	private OAuth20Service oauthService;
	private String profileUrl;
	private String service;
	private String state;
	
	public SNSLogin() {
		
	}
	
	//ServiceBuilder Ŭ������ Ȱ���� �츮�� �Ҽȷα���API ������ �����.
	public SNSLogin(SnsValue sns, HttpSession session) {
		this.state = generateState();
		session.setAttribute("state", state);
		
		this.oauthService = new ServiceBuilder(sns.getClientId())
				.apiSecret(sns.getClientSecret())
				.callback(sns.getRedirectUrl())
				.build(sns.getApi20Instance());	//�� sns ����ü�� build
		
		this.profileUrl = sns.getProfileUrl();
		this.service = sns.getService();
		
		System.out.println("===========Create oauthService!===========");
		System.out.println("SNSLogin state : " + this.state);
		System.out.println("==========================================");
	}
	
	//��ȿ�� �˻縦 ���� state ����
	public String generateState() {
		/*
		 * SecureRandom�� Random�� ����
		 * Random�� �ð��� ���� seed�� ����ϴµ� �̷��� �Ǹ� ���� �ð��뿡 ���� seed���� ����.
		 * ������ SecureRandom�� �ð��� ���󼭵� �ƴϰ� ��¥ �ڱ� �ڴ���� �������� �����.
		 */
		SecureRandom state = new SecureRandom();
		return new BigInteger(130, state).toString(32);
	}
	
	public String getAuthorizationUrl() {
		// �α����������� �̵��� url ����
		return this.oauthService.getAuthorizationUrl();
	}
	
	//�α��� �������� �� ���� code�� ������ access token�� ��������, accessToken���� �������� ��ȸ�ϴ� url�� ��� ���� �޼ҵ�
	public UserVO getProfile(String code, HttpSession session) throws Exception {
		System.out.println("\n============�α��� ����! Profile ���� ��������==============");
		System.out.println("This.state : " + this.state);
		System.out.println("session.state : " + session.getAttribute("state"));
		System.out.println("=======================================================");
		
		Response response = null;
		if (this.state.equals(session.getAttribute("state"))) {
			// accessToken ���
			OAuth2AccessToken accessToken = oauthService.getAccessToken(code); 
			// accessToken�� �̿��Ͽ� ���������� ������� ��û
			OAuthRequest request = new OAuthRequest(Verb.POST, this.profileUrl);
			//request�� accessToken ���
			oauthService.signRequest(accessToken, request);	
			// request�� ���� ������������ ���� response(JSON ����)
			response = oauthService.execute(request);
		}
		
		System.out.println("\n==========���̹� �α��μ��� ������ responseBody===========");
		System.out.println(response.getBody());
		System.out.println("========================================================");
		
		return profileParsing(response.getBody());
	}

	private UserVO profileParsing(String body) throws ParseException {
		UserVO user = new UserVO();
		
		JSONParser jsonParse = new JSONParser();
		//JSONParse�� json�����͸� �־� �Ľ��� ���� JSONObject�� ��ȯ�Ѵ�. 
		JSONObject jsonObj = (JSONObject) jsonParse.parse(body);
		jsonObj = (JSONObject) jsonObj.get("response");
		
		if (this.service.equals("naver")) {
			user.setSocial("naver");
			user.setUserId((String) jsonObj.get("id"));
			user.setUserEmail((String) jsonObj.get("email"));
			user.setUserPhone((String) jsonObj.get("mobile"));
			user.setUserName((String) jsonObj.get("name"));
		}
		
		return user;
	}

}
