//scribejava ���̺귯���� ���� Naver authorize, token������ ������ ������ �������ִ� �κ�.
package com.oauth2.study.auth;

import com.github.scribejava.core.builder.api.DefaultApi20;
/*
 * DefaultApi20
 * 1. scribejava-core ���̺귯���� �̿��ϱ� ���� �� �Ҽȷα��θ��� ����ü�� ������ִ� �۾�.
 * 2. �Ҽȸ��� �ʿ��� authorize url, token url ���� ������ ������ �˾Ƽ� ��������.
 * 3. �� Ŭ������ abstract �����̱� ������ Override�� ��������� �ϴ� �޼��尡 ����(getAccessTokenEndpoint, getAuthorizationBaseUrl)
 * 4. �̱��� Ŭ������. -> �̱��� Ŭ������ ������Ʈ ������ ��ü�� �� �Ѱ� �����ؾ� �ϴ� Ŭ������ ����.
 */
public class NaverAPI20 extends DefaultApi20 implements SnsUrls {
	//�̱��� Ŭ�����̹Ƿ� private. -> �ܺο��� ��ü�� �����ϱ� ���� �޼��尡 �ʿ���.
	private NaverAPI20() {
		
	}
	//����Ŭ������ �̿��Ͽ� ��ü ����.
	//static Ŭ�����̹Ƿ� ���� Ŭ����.
	private static class InstanceHolder {
		//static �����̱� ������ ���� ����, final �����̱� ������ ���� ������� ����.
		public static final NaverAPI20 INSTANCE = new NaverAPI20();
	}
	//�ܺο��� NaverAPI20 ��ü�� ȣ���� �� ����ϴ� �޼���
	//static �޼���� ���� �޼�����.
	public static NaverAPI20 instance() {
		return InstanceHolder.INSTANCE;
	}
	
	@Override
	public String getAccessTokenEndpoint() {
		// TODO Auto-generated method stub
		return NAVER_ACCESS_TOKEN;
	}

	@Override
	protected String getAuthorizationBaseUrl() {
		// TODO Auto-generated method stub
		return NAVER_AUTH;
	}
}
