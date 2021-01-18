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

//우리의 socialloginAPI 정보를 scribejava에 등록해 scribejava를 활용해 소셜로그인을 편리하게 할 수 있도록 해주는 작업.
@Service
public class SNSLogin {
	private OAuth20Service oauthService;
	private String profileUrl;
	private String service;
	private String state;
	
	public SNSLogin() {
		
	}
	
	//ServiceBuilder 클래스를 활용해 우리의 소셜로그인API 정보를 등록함.
	public SNSLogin(SnsValue sns, HttpSession session) {
		this.state = generateState();
		session.setAttribute("state", state);
		
		this.oauthService = new ServiceBuilder(sns.getClientId())
				.apiSecret(sns.getClientSecret())
				.callback(sns.getRedirectUrl())
				.build(sns.getApi20Instance());	//각 sns 구현체로 build
		
		this.profileUrl = sns.getProfileUrl();
		this.service = sns.getService();
		
		System.out.println("===========Create oauthService!===========");
		System.out.println("SNSLogin state : " + this.state);
		System.out.println("==========================================");
	}
	
	//유효성 검사를 위한 state 생성
	public String generateState() {
		/*
		 * SecureRandom과 Random의 차이
		 * Random은 시간에 따라 seed을 출력하는데 이렇게 되면 같은 시간대에 같은 seed값이 나옴.
		 * 하지만 SecureRandom은 시간에 따라서도 아니고 진짜 자기 멋대로의 랜덤값을 출력함.
		 */
		SecureRandom state = new SecureRandom();
		return new BigInteger(130, state).toString(32);
	}
	
	public String getAuthorizationUrl() {
		// 로그인페이지로 이동할 url 리턴
		return this.oauthService.getAuthorizationUrl();
	}
	
	//로그인 성공했을 때 받은 code를 가지고 access token을 가져오고, accessToken으로 프로필을 조회하는 url을 얻기 위한 메소드
	public UserVO getProfile(String code, HttpSession session) throws Exception {
		System.out.println("\n============로그인 성공! Profile 정보 가져오기==============");
		System.out.println("This.state : " + this.state);
		System.out.println("session.state : " + session.getAttribute("state"));
		System.out.println("=======================================================");
		
		Response response = null;
		if (this.state.equals(session.getAttribute("state"))) {
			// accessToken 얻기
			OAuth2AccessToken accessToken = oauthService.getAccessToken(code); 
			// accessToken을 이용하여 프로필정보 얻기위한 요청
			OAuthRequest request = new OAuthRequest(Verb.POST, this.profileUrl);
			//request에 accessToken 등록
			oauthService.signRequest(accessToken, request);	
			// request를 통해 프로필정보를 얻은 response(JSON 형태)
			response = oauthService.execute(request);
		}
		
		System.out.println("\n==========네이버 로그인성공 프로필 responseBody===========");
		System.out.println(response.getBody());
		System.out.println("========================================================");
		
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
