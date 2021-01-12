package com.oauth2.study.auth;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;

//우리의 socialloginAPI 정보를 scribejava에 등록해 scribejava를 활용해 소셜로그인을 편리하게 할 수 있도록 해주는 작업. 
public class SNSLogin {
	private OAuth20Service oauthService;
	
	//ServiceBuilder 클래스를 활용해 우리의 소셜로그인API 정보를 등록함.
	public SNSLogin(SnsValue sns) {
		this.oauthService = new ServiceBuilder(sns.getClientId())
				.apiSecret(sns.getClientSecret())
				.callback(sns.getRedirectUrl())
				.defaultScope("profile")
				.build(sns.getApi20Instance());
	}

	public String getNaverAuthURL() {
		// 로그인페이지로 이동할 url 리턴
		return this.oauthService.getAuthorizationUrl();
	}

}
