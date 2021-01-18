//�� �������� �α��� �������� �̵��ϴ� url, access token�� ������ ���� url, profile ������ ������ ����  
//url���� ������ ������ �ִ� �������̽�.
//�ش� �������̽��� �ִ� url ������ ����� ���� ���� �͵��̶� �������̽��� ������ ����.
package com.oauth2.study.auth;

public interface SnsUrls {
	//���̹� ���̵�� �α��� ��ư ������ �� �̵��ϴ� ������
	static final String NAVER_AUTH="https://nid.naver.com/oauth2.0/authorize";
	//callback �� ���̹� access token�� �޾ƿ��� url
	static final String NAVER_ACCESS_TOKEN = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code";
	//access token�� ������ ���̹� �������� ������ ���� url
	static final String NAVER_PROFILE = "https://openapi.naver.com/v1/nid/me";
}
