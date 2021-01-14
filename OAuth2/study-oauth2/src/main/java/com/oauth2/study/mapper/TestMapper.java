package com.oauth2.study.mapper;

import java.util.List;

import com.oauth2.study.dto.UserVO;

public interface TestMapper {
	public List<UserVO> selectAlluser();
	public int checkUserIdNaver(String userId);
}
