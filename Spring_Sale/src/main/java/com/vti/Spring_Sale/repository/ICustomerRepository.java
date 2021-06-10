package com.vti.Spring_Sale.repository;

import java.util.List;
import java.util.Set;

import com.vti.Spring_Sale.dto.CustomerOrder;
import com.vti.Spring_Sale.dto.OrderDTO;
import com.vti.Spring_Sale.entity.*;

public interface ICustomerRepository {

	List<CustomerOrder> getAllCustomers();

	CustomerOrder getCustomerById(int id);

	List<CustomerOrder> getAllCustomersByOptionals(Integer pageNumber, Integer pageSize, String sortBy,
			Integer sortType);

	OrderDTO getOrder(int customerId, int orderId);

}
