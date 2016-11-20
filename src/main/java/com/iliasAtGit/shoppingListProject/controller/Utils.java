package com.iliasAtGit.shoppingListProject.controller;

import org.slf4j.Logger;

public class Utils {
	static String handleConstraintViolationException(String rootCause){
		 String[] diveParts = rootCause.split("Duplicate entry");
		 diveParts = diveParts[1].split("for");
		 return "Duplicate entry " + diveParts[0].trim();
	}
	static String filterException(Logger logger, Throwable throwed, String rootCause){
		logger.error("============="+throwed.getClass().getCanonicalName()+"================");
		logger.error("============="+throwed.getMessage()+"================");
		if (throwed.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
			logger.error("=============ConstraintViolationException================");
			logger.error(rootCause);
			return Utils.handleConstraintViolationException(rootCause);
		} else {
			return "An exception occurred";
		}
	}
}
