package com.tutorial.spring.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.tutorial.spring.dto.CategoryVO;

@Repository
public class CategoryDAO {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session; 
	
	public List<CategoryVO> selectAll() {
		List<CategoryVO> categoryList = session.selectList("testDB.selectAllCategories");
		
		return categoryList;
	}
}
