package com.iliasAtGit.shoppingListProject.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.iliasAtGit.shoppingListProject.dao.ShopDepartmentDao;

@Component
public class ShopDepartmentValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ShopDepartmentDao.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		String sd_name = errors.getFieldValue("name").toString();

		if (sd_name.length() < 2)
			errors.rejectValue("name", "validator.AlphanumericLen2");
	
		if (!StringUtils.isAlphanumeric(sd_name))
			errors.rejectValue("name", "validator.AlphanumericOnly");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "shopDepart.form.validator.name", "Please insert the Shop Department Name");
	}

}
