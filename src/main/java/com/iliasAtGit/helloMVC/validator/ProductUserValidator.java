package com.iliasAtGit.helloMVC.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.iliasAtGit.helloMVC.model.Product;

@Component
public class ProductUserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, 
												  "name", 
												  "product.form.validator.name",
												  "Please enter the Products name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, 
												  "shopDepartment.id", 
												  "product.form.validator.shopDepartment",
												  "Please select a Shop Department");

	}

}
