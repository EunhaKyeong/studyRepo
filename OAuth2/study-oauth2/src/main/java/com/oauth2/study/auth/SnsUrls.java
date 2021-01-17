//각 계정마다 로그인 페이지로 이동하는 url, access token을 가지러 가는 url, profile 정보를 가지러 가는  
//url들의 정보를 가지고 있는 인터페이스.
//해당 인터페이스에 있는 url 정보는 변경될 일이 없는 것들이라서 인터페이스로 구현한 것임.
package com.oauth2.study.auth;

public interface SnsUrls {
	//네이버 아이디로 로그인 버튼 눌렀을 때 이동하는 페이지
	static final String NAVER_AUTH="https://nid.naver.com/oauth2.0/authorize";
	//callback 시 네이버 access token을 받아오는 url
	static final String NAVER_ACCESS_TOKEN = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code";
	//access token을 가지고 네이버 프로필을 가지러 가는 url
	static final String NAVER_PROFILE = "https://openapi.naver.com/v1/nid/me";
}
