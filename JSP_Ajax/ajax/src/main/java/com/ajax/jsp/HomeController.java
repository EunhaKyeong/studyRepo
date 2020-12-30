package com.ajax.jsp;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajax.jsp.dao.Jamong;
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

	@RequestMapping(value="/", method=RequestMethod.POST)
	@ResponseBody
	public Object insertUser(@RequestBody UserDTO userDTO) {
		 userDAO.insertUser(userDTO);
		 
		 HashMap<String, Object> userHm = new HashMap<String, Object>();
	     userHm.put("userName", userDTO.getUserName());
	     userHm.put("userAge", userDTO.getUserAge());
	     userHm.put("userGender", userDTO.getUserGender());
	     userHm.put("userEmail", userDTO.getUserEmail());
	        
	    return userHm;
	}
	
	@RequestMapping(value="/stringify", method=RequestMethod.GET)
    public String stringifyGet() {
		return "jamong";
    }
	
	@RequestMapping(value="/stringify", method=RequestMethod.POST)
    @ResponseBody
    public Object stringify(@RequestBody Jamong jamong) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", jamong.getName());
        map.put("age", jamong.getAge());
        return map;
    }
}
