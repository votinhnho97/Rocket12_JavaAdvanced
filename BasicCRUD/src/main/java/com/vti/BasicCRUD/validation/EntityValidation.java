package com.vti.BasicCRUD.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class EntityValidation {
	private ValidatorFactory validatorFactory;
	private Validator validator;

	public EntityValidation() {
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}

	public <T> void validation(T object) {
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(object);
		for (ConstraintViolation<T> constraintViolation : constraintViolations) {
			System.out.println(constraintViolation.getMessage());
		}
	}
}
