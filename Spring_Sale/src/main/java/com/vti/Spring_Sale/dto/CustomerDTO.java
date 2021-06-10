package com.vti.Spring_Sale.dto;

import java.util.HashSet;
import java.util.Set;

import com.vti.Spring_Sale.entity.Order;

public class CustomerDTO {
	private int customerId;
	private String fullName;
	private String phone;

	public CustomerDTO() {
		super();
	}

	public CustomerDTO(int customerId, String fullName, String phone) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.phone = phone;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
