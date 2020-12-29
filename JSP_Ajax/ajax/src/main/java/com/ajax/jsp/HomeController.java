package com.ajax.jsp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajax.jsp.dao.UserDAO;
import com.ajax.jsp.dto.UserDTO;

@Controller
public class HomeController {
	@Inject
	UserDAO userDAO;
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		List<UserDTO> userList = userDAO.selectAllUser();
		model.addAttribute("userList", userList);
		
		return "index";
	}

	@RequestMapping(value="/insertUser", method=RequestMethod.POST)
	@ResponseBody
	public void insertUser(HttpServletRequest request) {
		 UserDTO user = new UserDTO(); user.setUserName(request.getParameter("name"));
		 user.setUserAge(Integer.parseInt(request.getParameter("age")));
		 user.setUserGender(request.getParameter("gender"));
		 user.setUserEmail(request.getParameter("email"));
		 
		 userDAO.insertUser(user);
	}
	
	@ResponseBody
	@RequestMapping(value = "/insertUser/list.json")
	public HashMap<String, Object> insertUserList() {
		List<UserDTO> userList = userDAO.selectAllUser();
		HashMap<String, Object> userHm1 = new HashMap<String, Object>();
		HashMap<String, Object> userHm2 = new HashMap<String, Object>();
		
		for (int i=0; i<userList.size(); i++) {
			userHm1.put("userName", userList.get(0).getUserName());
			userHm1.put("userAge", userList.get(0).getUserAge());
			userHm1.put("userGender", userList.get(0).getUserGender());
			userHm1.put("userEmail", userList.get(0).getUserEmail());
		}
		
		return userHm1;
	}
}
