package com.tutorial01.tutorial.model.dto;

public class ProductDTO {
	private String stationery_name;
	private double stationery_price;
	public String getStationery_name() {
		return stationery_name;
	}
	public void setStationery_name(String stationery_name) {
		this.stationery_name = stationery_name;
	}
	public double getStationery_price() {
		return stationery_price;
	}
	public void setStationery_price(double stationery_price) {
		this.stationery_price = stationery_price;
	}
	public ProductDTO(String stationery_name, double stationery_price) {
		super();	//ProductDTO의 부모생성자(그냥 ProductDTO())를 호출할 때 사용.
		this.stationery_name = stationery_name;
		this.stationery_price = stationery_price;
	}
}
