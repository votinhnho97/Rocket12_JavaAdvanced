package com.vti.Spring_Sale.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vti.Spring_Sale.config.exception.ExceptionResponse;
import com.vti.Spring_Sale.config.internationalization.MessageProperty;
import com.vti.Spring_Sale.dto.*;
import com.vti.Spring_Sale.service.CustomerService;
import com.vti.Spring_Sale.service.ICustomerService;

@CrossOrigin(origins = "*", maxAge = 4500)
@RestController
@RequestMapping(value = "api/v1/customers")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private MessageProperty msgProperty;

	@RequestMapping(method = RequestMethod.GET)
	public List<CustomerOrder> getAllCustomers(@RequestParam(required = false) @Min(value = 1, message = "{Customer.getAllCustomers.pageNumber.min}") Integer pageNumber,
			@RequestParam(required = false) Integer pageSize, @RequestParam(required = false) String sort) {
//		try {
//			throw new EntityNotFoundException();
//		} catch (EntityNotFoundException e) {
//			// Xử lý exception nội bộ trong controller
//			ExceptionResponse er = new ExceptionResponse("Không tìm thấy Entity.", "Bảng `Customers` đã bị xóa.", HttpStatus.NOT_FOUND, "http://.../");
//			return new ResponseEntity<Object>(er, er.getCode());
//		}
//		throw new EntityNotFoundException();
		Integer sortType = 0;
		if (sort != null && sort != "") {
			if (sort.substring(0, 1) == "-")
				sortType = 1;
		}
		
		String message = msgProperty.getMessage("Customer.getAllCustomers.message");
		System.out.println(message);
		
		// Local Exception: xử lý nội bộ trong Controller, khi muốn cùng 1 lỗi xử lý
		// khác nhau ở mỗi Controller
		//
		// Global Exception: xử lý chung cho các exception ném ra từ các Controller
		// mặc định lỗi được ném ra từ lớp ResponseEntityExceptionHandler
		// Custom Exception sẽ extend lớp ResponseEntityExceptionHandler.
		return customerService.getAllCustomersByOptionals(pageNumber, pageSize, sort, sortType);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public CustomerOrder getCustomerById(@PathVariable(name = "id") int id) {
		return customerService.getCustomerById(id);
	}

	@RequestMapping(value = "/{customerId}/orders/{orderId}", method = RequestMethod.GET)
	public OrderDTO getOrder(@PathVariable(name = "customerId") int customerId,
			@PathVariable(name = "orderId") int orderId) {

		return customerService.getOrder(customerId, orderId);
	}
}
