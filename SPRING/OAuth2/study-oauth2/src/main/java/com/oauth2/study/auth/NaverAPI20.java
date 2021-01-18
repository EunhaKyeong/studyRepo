//scribejava 라이브러리를 통해 Naver authorize, token정보를 가지로 연결을 진행해주는 부분.
package com.oauth2.study.auth;

import com.github.scribejava.core.builder.api.DefaultApi20;
/*
 * DefaultApi20
 * 1. scribejava-core 라이브러리를 이용하기 위해 각 소셜로그인마다 구현체를 만들어주는 작업.
 * 2. 소셜마다 필요한 authorize url, token url 등의 정보만 있으면 알아서 연결해줌.
 * 3. 이 클래스는 abstract 형식이기 때문에 Override로 구현해줘야 하는 메서드가 존재(getAccessTokenEndpoint, getAuthorizationBaseUrl)
 * 4. 싱글톤 클래스임. -> 싱글톤 클래스란 프로젝트 내에서 객체가 딱 한개 존재해야 하는 클래스를 말함.
 */
public class NaverAPI20 extends DefaultApi20 implements SnsUrls {
	//싱글톤 클래스이므로 private. -> 외부에서 객체를 생성하기 위한 메서드가 필요함.
	private NaverAPI20() {
		
	}
	//내부클래스를 이용하여 객체 생성.
	//static 클래스이므로 전역 클래스.
	private static class InstanceHolder {
		//static 변수이기 때문에 전역 변수, final 변수이기 때문에 값이 변경되지 않음.
		public static final NaverAPI20 INSTANCE = new NaverAPI20();
	}
	//외부에서 NaverAPI20 객체를 호출할 때 사용하는 메서드
	//static 메서드로 전역 메서드임.
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
