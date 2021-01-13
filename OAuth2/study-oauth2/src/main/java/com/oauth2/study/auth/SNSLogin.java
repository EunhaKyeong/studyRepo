package com.oauth2.study.auth;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;

//�츮�� socialloginAPI ������ scribejava�� ����� scribejava�� Ȱ���� �Ҽȷα����� ���ϰ� �� �� �ֵ��� ���ִ� �۾�. 
public class SNSLogin {
	private OAuth20Service oauthService;
	private String profileUrl;
	
	//ServiceBuilder Ŭ������ Ȱ���� �츮�� �Ҽȷα���API ������ �����.
	public SNSLogin(SnsValue sns) {
		this.oauthService = new ServiceBuilder(sns.getClientId())
				.apiSecret(sns.getClientSecret())
				.callback(sns.getRedirectUrl())
				.defaultScope("profile")
				.build(sns.getApi20Instance());
		
		this.profileUrl = sns.getProfileUrl();
	}

	public String getNaverAuthURL() {
		// �α����������� �̵��� url ����
		return this.oauthService.getAuthorizationUrl();
	}
	
	//�α��� �������� �� ���� code�� ������ access token�� ��������, accessToken���� �������� ��ȸ�ϴ� url�� ��� ���� �޼ҵ�
	public String getProfile(String code) throws Exception {
		// accessToken ���
		OAuth2AccessToken accessToken = oauthService.getAccessToken(code); 
		// accessToken�� �̿��Ͽ� ���������� ������� ��û
		OAuthRequest request = new OAuthRequest(Verb.POST, this.profileUrl);
		//request�� accessToken ���
		oauthService.signRequest(accessToken, request);	
		// request�� ���� ������������ ���� response(JSON ����)
		Response response = oauthService.execute(request);
		
		return response.getBody();
	}

}
