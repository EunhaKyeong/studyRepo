package com.tutorial.spring.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.tutorial.spring.dto.ProductVO;

@Repository
public class ProductDAO {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session; 
	
	public List<ProductVO> selectAll() {
		List<ProductVO> productlist = session.selectList("testDB.selectAllProducts");
		
		return productlist;
	}
	
	public List<ProductVO> selectLimit(int startIdx) {
		List<ProductVO> productlist = session.selectList("testDB.selectLimitProducts", startIdx);
		
		return productlist;
	}
	
	public List<ProductVO> selectCategory(int categoryId) {
		List<ProductVO> productlist = session.selectList("testDB.selectProductsCategory", categoryId);
		
		return productlist;
	}
}
