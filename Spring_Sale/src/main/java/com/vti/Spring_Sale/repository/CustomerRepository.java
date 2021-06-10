package com.vti.Spring_Sale.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;

import com.vti.Spring_Sale.dto.*;
import com.vti.Spring_Sale.entity.*;
import com.vti.Spring_Sale.utils.*;

public class CustomerRepository implements ICustomerRepository {
	private ICRUDUtils crudUtils;
	private List<Class<?>> listClass;

	public CustomerRepository() {
		listClass = new ArrayList<Class<?>>();
		listClass.add(Customer.class);
		listClass.add(Order.class);

		crudUtils = new CRUDHibernate(listClass);
		crudUtils.open();
	}

	private List<CustomerOrder> tranferDataObject(List<?> result) {
		// Transfer data object
		List<CustomerOrder> resultReturn = new ArrayList<CustomerOrder>();
		for (Object customer : result) {
			Customer c = (Customer) customer;
			CustomerOrder co = new CustomerOrder(c.getCustomerId(), c.getFullName(), c.getPhone(),
					DTO.orderListTransfer(c.getOrders()));
			resultReturn.add(co);
		}
		return resultReturn;
	}

	@Override
	public List<CustomerOrder> getAllCustomers() {
		List<?> resultRaw = crudUtils.findAll(Customer.class, null, 0, 0, 0, null, null, null);
		return tranferDataObject(resultRaw);
	}

	@Override
	public CustomerOrder getCustomerById(int id) {
		List<?> resultRaw = crudUtils.findByColumns(Customer.class, null, null, 0, 0, 1, "id", "=", id);
		// Transer data object
		if (resultRaw.size() > 0) {
			Customer c = (Customer) resultRaw.get(0);
			CustomerOrder co = new CustomerOrder(c.getCustomerId(), c.getFullName(), c.getPhone(),
					DTO.orderListTransfer(c.getOrders()));
			return co;
		}
		return null;
	}

	@Override
	public List<CustomerOrder> getAllCustomersByOptionals(Integer pageNumber, Integer pageSize, String sortBy,
			Integer sortType) {
		List<?> resultRaw = crudUtils.findAll(Customer.class, sortBy, sortType, pageNumber != null ? pageNumber : 0,
				pageSize != null ? pageSize : 0, null, null, null);
		return tranferDataObject(resultRaw);
	}

	@Override
	public OrderDTO getOrder(int customerId, int orderId) {
		CustomerOrder co = getCustomerById(customerId);
		List<OrderDTO> orders = new ArrayList<>(co.getOrders());

		return orders.get(orderId);
	}
}
