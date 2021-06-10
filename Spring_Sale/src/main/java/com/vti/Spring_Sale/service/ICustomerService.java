package com.vti.Spring_Sale.service;

import java.util.List;
import java.util.Set;

import com.vti.Spring_Sale.dto.*;

public interface ICustomerService {

	List<CustomerOrder> getAllCustomers();

	CustomerOrder getCustomerById(int id);

	List<CustomerOrder> getAllCustomersByOptionals(Integer pageNumber, Integer pageSize, String sortBy,
			Integer sortType);

	OrderDTO getOrder(int customerId, int orderId);

}
