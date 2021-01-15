package com.oauth2.study.service;

import java.util.List;

import com.oauth2.study.dto.UserVO;

public interface TestService {
	public List<UserVO> getAllUser();
	public int checkIdNaver(String userId);
	public void insertUser(UserVO newUser);
}
