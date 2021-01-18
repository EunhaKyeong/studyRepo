package com.oauth2.study.auth;

import com.github.scribejava.core.builder.api.DefaultApi20;

import lombok.Data;

/*
 * �� sns�� ����, clientId, clientSecret, redirectUrl(=callback)�� ������ ��� ������ VO ����
 * sns�� ������ �̰��� �� ��´ٰ� �����ϸ� ��.
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
		 //servlet-context���� service, clientId, clientSecret, redirectUrl�� ������ �� �Բ� ���������� 
		 //profileUrl, ����ü�� �Բ� ���������� �ʾƼ� ���񽺺��� ��������� ��.
		 if (service.equals("naver")) {
			 this.api20Instance = NaverAPI20.instance();	//���񽺺� ����ü�� ����.
			 this.profileUrl = NAVER_PROFILE;
		 }
	}
}
