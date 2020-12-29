package com.ajax.jsp.dao;

import java.util.List;

import com.ajax.jsp.dto.UserDTO;

interface UserITF {
	public List<UserDTO> selectAllUser();
	public void insertUser(UserDTO user);
}
