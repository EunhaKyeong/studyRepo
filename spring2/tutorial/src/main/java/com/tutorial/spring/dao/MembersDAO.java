package com.tutorial.spring.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.tutorial.spring.dto.MembersVO;

import java.util.List;

import javax.annotation.Resource;

@Repository	//root 컨테이너에 빈 객체로 생성해주는 어노테이션.
public class MembersDAO {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session; 
	
	// 1개만 select
	public MembersVO select(String email) {
		MembersVO member = session.selectOne("membersDB.selectMember", email);
		return member;
	}
		
	// 여러 개 select
	public List<MembersVO> selectAll() {
		List<MembersVO> memberList = session.selectList("membersDB.selectAllMembers");
		return memberList;		
	}
	
	//insert
	public void insert(String email) {
		MembersVO member = new MembersVO();
		member.setEmail(email);
		session.insert("membersDB.insertMember", email);
	}
}
