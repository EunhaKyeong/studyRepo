package com.oauth2.study.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.oauth2.study.dto.UserVO;
import java.util.Map;

@Controller
public class MainController {
	
	@RequestMapping(value="/")
	public String index(HttpSession session, HttpServletRequest request, Model model) {
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if (flashMap!=null) {
			UserVO userInfo = (UserVO) flashMap.get("user");
			model.addAttribute("userName", userInfo.getUserName());
		}
		
		return "index";
	}
}
