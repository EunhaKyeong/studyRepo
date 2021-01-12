package com.oauth2.study.auth;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;

//�츮�� socialloginAPI ������ scribejava�� ����� scribejava�� Ȱ���� �Ҽȷα����� ���ϰ� �� �� �ֵ��� ���ִ� �۾�. 
public class SNSLogin {
	private OAuth20Service oauthService;
	
	//ServiceBuilder Ŭ������ Ȱ���� �츮�� �Ҽȷα���API ������ �����.
	public SNSLogin(SnsValue sns) {
		this.oauthService = new ServiceBuilder(sns.getClientId())
				.apiSecret(sns.getClientSecret())
				.callback(sns.getRedirectUrl())
				.defaultScope("profile")
				.build(sns.getApi20Instance());
	}

	public String getNaverAuthURL() {
		// �α����������� �̵��� url ����
		return this.oauthService.getAuthorizationUrl();
	}

}
