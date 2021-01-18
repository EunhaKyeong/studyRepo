package com.oauth2.study.auth;

import com.github.scribejava.core.builder.api.DefaultApi20;

import lombok.Data;

/*
 * 각 sns의 종류, clientId, clientSecret, redirectUrl(=callback)의 정보를 담는 일종의 VO 역할
 * sns의 정보는 이곳에 다 담는다고 생각하면 됨.
 */
@Data
public class SnsValue implements SnsUrls{
	private String service;
	private String clientId;
	private String clientSecret;
	private String redirectUrl;
	private DefaultApi20 api20Instance;
	private String profileUrl;
	
	public SnsValue(String service, String clientId, String clientSecret, String redirectUrl) { 
		 this.service = service; 
		 this.clientId = clientId;
		 this.clientSecret = clientSecret; 
		 this.redirectUrl = redirectUrl; 
		 //servlet-context에서 service, clientId, clientSecret, redirectUrl은 빈등록할 때 함께 저장하지만 
		 //profileUrl, 구현체는 함께 저장해주지 않아서 서비스별로 저장해줘야 함.
		 if (service.equals("naver")) {
			 this.api20Instance = NaverAPI20.instance();	//서비스별 구현체를 지정.
			 this.profileUrl = NAVER_PROFILE;
		 }
	}
}
