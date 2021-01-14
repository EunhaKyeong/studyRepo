package com.oauth2.study.dto;

import lombok.Data;

@Data
public class UserVO {
	private int userCode;
	private String social;
	private String userId;
	private String userEmail;
	private String userAddress;
	private String userPhone;
	private String userName;
}
