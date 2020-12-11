package com.tutorial.spring;

import java.sql.Connection;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tutorial.spring.dao.MembersDAO;
import com.tutorial.spring.dto.MembersVO;

@Controller
public class HomeController {

	// 루트컨테이너에 존재하는 Bean을 주입하고 싶을 땐 @Inject 어노테이션을 활용.
	@Inject
	private DataSource dataSource;
	@Inject
	private SqlSessionFactory sqlFactory;
	@Resource
	private MembersDAO member;
	
	@RequestMapping(value = "/")
	public String home1() {
		return "test";
	}
	
	// /list1 URI에 대한 요청 처리 - dataSource
	@RequestMapping(value = "/list1")
	public String home2() {
		
		try {
			Connection conn = (Connection) dataSource.getConnection();
		System.out.println("성공 : " + conn);
		
		} catch (Exception ex){
			System.out.println("실패..!");
			ex.printStackTrace();
		}
		
		return "list1";
	}
	
	// "/list1 URI에 대한 요청 처리 - Session
	@RequestMapping(value = "/list2")
	public String home3() {
		
		try {
			SqlSession session = sqlFactory.openSession();
			System.out.println("성공 : " + session);
				
		} catch (Exception ex){
			System.out.println("실패..!");
			ex.printStackTrace();
		}
		
		return "list2";
	}
	
	@RequestMapping(value="/members", method= {RequestMethod.GET, RequestMethod.POST})
	public String members(Model model, HttpServletRequest request, @RequestParam(defaultValue="") String email) {
		if (request.getMethod().equals("POST")) {
			member.insert(email);
		}
		List<MembersVO> m = member.selectAll();
		String emails = "";
		
		for (int i=0; i<m.size(); i++) {
			emails += m.get(i).getEmail() + "<br>";
		}
		model.addAttribute("email", emails);
		
		return "members";
	}
	
	@RequestMapping(value="/member")
	public String member() {
		return "member";
	}
	
	
}