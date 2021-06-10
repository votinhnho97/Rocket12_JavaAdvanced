package com.vti.Spring_Sale.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerId")
	private int customerId;

	@Column(name = "fullName", length = 255)
	@Length(min = 6, max = 255)
	private String fullName;

	@Column(name = "phone", length = 15)
	@Length(min = 10, max = 10)
	private String phone;

	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	@Size(min = 0)
	@Valid
	private Set<Order> orders = new HashSet<Order>();

	public Customer() {
		super();
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

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
}
