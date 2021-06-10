package com.vti.Spring_Sale.utils;

import java.util.HashSet;
import java.util.Set;

import com.vti.Spring_Sale.entity.*;
import com.vti.Spring_Sale.dto.*;

public class DTO {

	private static OrderDTO orderTransfer(Object fromObject) {
		Order order = (Order) fromObject;
		OrderDTO toObject = new OrderDTO(order.getOrderId(), order.getAmount(), order.getCreateDate());
		return toObject;
	}

	public static Set<OrderDTO> orderListTransfer(Set<Order> fromObject) {
		Set<OrderDTO> toOject = new HashSet<OrderDTO>();
		for (Object object : fromObject) {
			toOject.add(orderTransfer(object));
		}

		return toOject;
	}

}
