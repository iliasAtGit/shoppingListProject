package com.iliasAtGit.shoppingListProject.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.iliasAtGit.shoppingListProject.dao.custom.ProductForUser;

@Component
public class ProductUserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ProductForUser.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
												  "productName",
												  "product.form.validator.name",
												  "Please enter the Products name");

		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,
			//									  "id",
				//								  "product.form.validator.shopDepartment",
					//							  "Please select a Shop Department");

	}

}
