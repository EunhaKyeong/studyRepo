package com.oauth2.study.auth;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.oauth2.study.dto.UserVO;

//�츮�� socialloginAPI ������ scribejava�� ����� scribejava�� Ȱ���� �Ҽȷα����� �����ϰ� �� �� �ֵ��� ���ִ� �۾�. 
public class SNSLogin {
	private OAuth20Service oauthService;
	private String profileUrl;
	private String service;
	
	//ServiceBuilder Ŭ������ Ȱ���� �츮�� �Ҽȷα���API ������ �����.
	public SNSLogin(SnsValue sns) {
		this.oauthService = new ServiceBuilder(sns.getClientId())
				.apiSecret(sns.getClientSecret())
				.callback(sns.getRedirectUrl())
				.defaultScope("profile")
				.build(sns.getApi20Instance());
		
		this.profileUrl = sns.getProfileUrl();
		this.service = sns.getService();
	}

	public String getNaverAuthURL() {
		// �α����������� �̵��� url ����
		return this.oauthService.getAuthorizationUrl();
	}
	
	//�α��� �������� �� ���� code�� ������ access token�� ��������, accessToken���� �������� ��ȸ�ϴ� url�� ��� ���� �޼ҵ�
	public UserVO getProfile(String code) throws Exception {
		// accessToken ���
		OAuth2AccessToken accessToken = oauthService.getAccessToken(code); 
		// accessToken�� �̿��Ͽ� ���������� ������� ��û
		OAuthRequest request = new OAuthRequest(Verb.POST, this.profileUrl);
		//request�� accessToken ���
		oauthService.signRequest(accessToken, request);	
		// request�� ���� ������������ ���� response(JSON ����)
		Response response = oauthService.execute(request);
		System.out.println("==========���̹� �α��μ��� ������ responseBody===========");
		System.out.println(response.getBody());
		System.out.println("==========���̹� �α��μ��� ������ responseBody===========");
		
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