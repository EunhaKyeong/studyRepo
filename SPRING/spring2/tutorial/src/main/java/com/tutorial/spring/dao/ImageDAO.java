package com.tutorial.spring.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.tutorial.spring.dto.ImageVO;

@Repository
public class ImageDAO implements Image {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session; 
	
	@Override
	public void insertImage(int imageId, String imageName) {
		String imageUrl = "C:\\study\\spring2\\tutorial\\src\\main\\resources\\upload_images\\" + imageName;
		
		ImageVO imageVO = new ImageVO();
		imageVO.setImageId(imageId);
		imageVO.setImageName(imageName);
		imageVO.setImageUrl(imageUrl);
		
		session.insert("testDB.insertImage", imageVO);
	}

	@Override
	public int selectMaxImageId() {
		int maxId = session.selectOne("testDB.selectMaxImageId");
		
		return maxId;
	}

}
