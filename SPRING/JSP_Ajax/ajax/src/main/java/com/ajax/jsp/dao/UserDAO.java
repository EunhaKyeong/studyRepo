package com.ajax.jsp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ajax.jsp.dto.UserDTO;

@Repository
public class UserDAO implements UserITF {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session;

	@Override
	public List<UserDTO> selectAllUser() {
		List<UserDTO> userList = session.selectList("testDB.selectAllUser");
		
		return userList;
	}

	@Override
	public void insertUser(UserDTO user) {
		session.insert("testDB.insertUser", user);
	} 
	
}
