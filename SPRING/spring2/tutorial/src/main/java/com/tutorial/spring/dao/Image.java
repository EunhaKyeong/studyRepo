package com.tutorial.spring.dao;

interface Image {
	public void insertImage(int imageId, String imageName);
	public int selectMaxImageId();
}
