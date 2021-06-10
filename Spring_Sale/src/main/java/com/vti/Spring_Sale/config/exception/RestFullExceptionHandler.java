package com.vti.Spring_Sale.config.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE) // Ordered.HIGHEST_PRECEDENCE: ưu tiên khi bắt lỗi
@ControllerAdvice
public class RestFullExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler({EntityNotFoundException.class}) // mapped với lỗi cụ thể
	public ResponseEntity<Object> handledNotFoundException(EntityNotFoundException e){
		ExceptionResponse er = new ExceptionResponse("Không tìm thấy Entity.", "Bảng `Customers` đã bị xóa.", HttpStatus.NOT_FOUND, "http://.../");
		return new ResponseEntity<Object>(er, er.getCode());
	}
}
