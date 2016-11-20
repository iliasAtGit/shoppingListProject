package com.iliasAtGit.shoppingListProject.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

import com.iliasAtGit.shoppingListProject.service.ShoppingListService;


@RestController
@RequestMapping("/shoppingList")
public class ShoppingListController {
	

	@Autowired
	private ShoppingListService shoppingListService;

	@Autowired
	private LocaleResolver localeResolver;

	@Autowired
    private MessageSource messageSource;
	

	private static final Logger logger = LoggerFactory.getLogger(ShoppingListController.class);


	@RequestMapping(value = { "/display/{id}" }, method = RequestMethod.GET)
	public ModelAndView shopList(@PathVariable String id, ModelAndView modelAndView, HttpServletRequest request) {
		modelAndView = new ModelAndView("/shoppingList/display");
		modelAndView.addObject("shoppingList", shoppingListService.findByShopNoteId(new Short(id)));

		modelAndView.addObject("currentLocale", localeResolver.resolveLocale(request).getLanguage());
		modelAndView.addObject("submitBtn", messageSource.getMessage("form.submitBtn.add", null, localeResolver.resolveLocale(request)));
		return modelAndView;
	}
}