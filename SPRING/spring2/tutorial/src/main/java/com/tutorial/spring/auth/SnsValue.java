package com.tutorial.spring.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SnsValue {
	private String service;
	private String clientId;
	private String clientSecret;
	private String redirectUrl;
	
}
