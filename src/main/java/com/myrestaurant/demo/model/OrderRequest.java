package com.myrestaurant.demo.model;

import java.util.List;

public class OrderRequest {
	
	private String id;
	private String name;
	private String email;
	private String address;
	private String phone;
	
	private List<ItemsInfo> itemsInfo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<ItemsInfo> getItemsInfo() {
		return itemsInfo;
	}

	public void setItemsInfo(List<ItemsInfo> itemsInfo) {
		this.itemsInfo = itemsInfo;
	}
	
	
	
}
