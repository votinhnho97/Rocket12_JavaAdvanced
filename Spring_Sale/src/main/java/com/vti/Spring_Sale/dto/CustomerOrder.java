package com.vti.Spring_Sale.dto;

import java.util.HashSet;
import java.util.Set;

public class CustomerOrder {
	private int customerId;
	private String fullName;
	private String phone;
	private Set<OrderDTO> orders = new HashSet<OrderDTO>();

	public CustomerOrder(int customerId, String fullName, String phone, Set<OrderDTO> orders) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.phone = phone;
		this.orders = orders;
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

	public Set<OrderDTO> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderDTO> orders) {
		this.orders = orders;
	}

}
