package com.vti.Spring_Sale.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.vti.Spring_Sale.dto.*;
import com.vti.Spring_Sale.repository.CustomerRepository;
import com.vti.Spring_Sale.repository.ICustomerRepository;

@Service
public class CustomerService implements ICustomerService {
	private ICustomerRepository customerRepository;

	public CustomerService() {
		customerRepository = new CustomerRepository();
	}

	@Override
	public List<CustomerOrder> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}

	@Override
	public CustomerOrder getCustomerById(int id) {
		return customerRepository.getCustomerById(id);
	}

	@Override
	public List<CustomerOrder> getAllCustomersByOptionals(Integer pageNumber, Integer pageSize, String sortBy,
			Integer sortType) {
		return customerRepository.getAllCustomersByOptionals(pageNumber, pageSize, sortBy, sortType);
	}

	@Override
	public OrderDTO getOrder(int customerId, int orderId) {
		return customerRepository.getOrder(customerId, orderId);
	}

}
