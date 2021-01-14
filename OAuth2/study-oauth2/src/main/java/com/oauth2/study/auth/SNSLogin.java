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

//우리의 socialloginAPI 정보를 scribejava에 등록해 scribejava를 활용해 소셜로그인을 편리하게 할 수 있도록 해주는 작업. 
public class SNSLogin {
	private OAuth20Service oauthService;
	private String profileUrl;
	private String service;
	
	//ServiceBuilder 클래스를 활용해 우리의 소셜로그인API 정보를 등록함.
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
		// 로그인페이지로 이동할 url 리턴
		return this.oauthService.getAuthorizationUrl();
	}
	
	//로그인 성공했을 때 받은 code를 가지고 access token을 가져오고, accessToken으로 프로필을 조회하는 url을 얻기 위한 메소드
	public UserVO getProfile(String code) throws Exception {
		// accessToken 얻기
		OAuth2AccessToken accessToken = oauthService.getAccessToken(code); 
		// accessToken을 이용하여 프로필정보 얻기위한 요청
		OAuthRequest request = new OAuthRequest(Verb.POST, this.profileUrl);
		//request에 accessToken 등록
		oauthService.signRequest(accessToken, request);	
		// request를 통해 프로필정보를 얻은 response(JSON 형태)
		Response response = oauthService.execute(request);
		System.out.println("==========네이버 로그인성공 프로필 responseBody===========");
		System.out.println(response.getBody());
		System.out.println("==========네이버 로그인성공 프로필 responseBody===========");
		
		return profileParsing(response.getBody());
	}

	private UserVO profileParsing(String body) throws ParseException {
		UserVO user = new UserVO();
		
		JSONParser jsonParse = new JSONParser();
		//JSONParse에 json데이터를 넣어 파싱한 다음 JSONObject로 변환한다. 
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
