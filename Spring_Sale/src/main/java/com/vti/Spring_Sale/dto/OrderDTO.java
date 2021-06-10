package com.vti.Spring_Sale.dto;

import java.util.Date;

public class OrderDTO {
	private int orderId;
	private int amount;
	private Date createDate;

	public OrderDTO() {
		super();
	}

	public OrderDTO(int orderId, int amount, Date createDate) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.createDate = createDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
