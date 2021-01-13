//각 sns의 종류, clientId, clientSecret, redirectUrl(=callback)의 정보를 담는 일종의 VO 역할
package com.oauth2.study.auth;

import com.github.scribejava.core.builder.api.DefaultApi20;

import lombok.Data;

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
		 if (service.equals("naver")) {
			 this.api20Instance = NaverAPI20.instance();
			 this.profileUrl = NAVER_PROFILE;
		 }
	}
}
