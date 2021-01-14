package com.oauth2.study.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oauth2.study.dto.UserVO;
import com.oauth2.study.service.TestServiceImpl;
import java.util.List;

@Controller
public class MainController {
	
	@RequestMapping(value="/")
	public String index() {
		
		return "index";
	}
}
