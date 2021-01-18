package com.oauth2.study.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.oauth2.study.dto.UserVO;
import com.oauth2.study.mapper.TestMapper;

@Service
public class TestServiceImpl implements TestService {
	@Inject
	TestMapper testMapper;
	
	@Override
	public List<UserVO> getAllUser() {
		List<UserVO> userVOList = testMapper.selectAlluser();
		
		return userVOList;
	}

	@Override
	public int checkIdNaver(String userId) {
		int checkuserId = testMapper.checkUserIdNaver(userId);
		
		return checkuserId;
	}
	
	@Override
	public void insertUser(UserVO newUser) {
		testMapper.insertUser(newUser);
		System.out.println("새 유저 등록 완료!");
	}
}
