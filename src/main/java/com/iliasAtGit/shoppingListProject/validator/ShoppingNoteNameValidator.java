package com.iliasAtGit.shoppingListProject.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.iliasAtGit.shoppingListProject.model.ShoppingNote;

@Component
public class ShoppingNoteNameValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return ShoppingNote.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "shopNote.form.validator.name", "Shopping Note is empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateStart", "shopNote.form.validator.dateStart", "Start date is empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateEnd", "shopNote.form.validator.dateEnd", "End date is empty");
	}
}
