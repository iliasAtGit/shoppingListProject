package com.iliasAtGit.helloMVC.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iliasAtGit.helloMVC.model.ShoppingNote;
import com.iliasAtGit.helloMVC.service.ShoppingNoteService;
import com.iliasAtGit.helloMVC.utils.DateFuncs;
import com.iliasAtGit.helloMVC.validator.ShoppingNoteNameValidator;

@RestController
@RequestMapping("/shoppingNote")
public class ShoppingNoteController {
	
	@Autowired
	private ShoppingNoteNameValidator shoppingNoteNameValidator;

	@Autowired
	private ShoppingNoteService shoppingNoteService;

	@Autowired
	private LocaleResolver localeResolver;

	@Autowired
    private MessageSource messageSource;
	

	private static final Logger logger = LoggerFactory.getLogger(ShoppingNoteController.class);

/*
	@InitBinder("shoppingNote")
	public void dataBinding(WebDataBinder binder) {
		binder.addValidators(shoppingNoteNameValidator);
		//TODO
		//Internationalize the date
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		dateFormat.setLenient(false);
				
		binder.registerCustomEditor(Date.class, "dateStart", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Date.class, "dateEnd", new CustomDateEditor(dateFormat, true));
	}
*/	
	@RequestMapping(value = { "/display" }, method = RequestMethod.GET)
	public ModelAndView display(ModelAndView modelAndView, HttpServletRequest request) {
		modelAndView.addObject("shoppingNotes", shoppingNoteService.findAll());
		modelAndView.addObject("submitBtn", messageSource.getMessage("form.submitBtn.add", null, localeResolver.resolveLocale(request)));
		return modelAndView;
	}
	
	@RequestMapping(value = { "/dispActive" }, method = RequestMethod.GET)
	public ModelAndView dispActive(ModelAndView modelAndView, HttpServletRequest request) {
		modelAndView.addObject("shoppingNotes", shoppingNoteService.findActive());
		modelAndView.addObject("currentLocale", localeResolver.resolveLocale(request).getLanguage());
		modelAndView.addObject("submitBtn", messageSource.getMessage("form.submitBtn.add", null, localeResolver.resolveLocale(request)));
		return modelAndView;
	}

	@RequestMapping(value = { "/addForm" }, method = RequestMethod.GET)
	public ModelAndView addForm(ModelAndView modelAndView, HttpServletRequest request) {
		modelAndView.addObject("shoppingNote", new ShoppingNote());
		modelAndView.addObject("currentLocale", localeResolver.resolveLocale(request).getLanguage());
		return modelAndView;
	}

	@RequestMapping(value = { "/addForm" }, method = RequestMethod.POST)
	public ModelAndView addForm(@Valid ShoppingNote shoppingNote,
							   BindingResult result,
							   ModelAndView modelAndView,
							   RedirectAttributes redir,
							   Exception exception) {
		
		shoppingNoteNameValidator.validate(shoppingNote, result);
		if (result.hasErrors())
			return modelAndView;
		
		String resultCallBack = null;
		
		try {
			//TODO
			shoppingNote.setCreatedOn(DateFuncs.GetUTCdatetimeAsDate());
			
			shoppingNoteService.save(shoppingNote);			          
		}
		catch (DataIntegrityViolationException dive) {
			logger.error("=============@create DataIntegrityViolationException================");
			logger.error(dive.getRootCause().toString());
			resultCallBack = "A Data Integrity Violation Exception occurred";
		}
		catch(PersistenceException pe){
			logger.error("=============@create PersistenceException================");
			if (pe.getCause() instanceof org.hibernate.exception.ConstraintViolationException){
				logger.error("=============@create ConstraintViolationException================");
			}
			logger.error(pe.getCause().toString());
			resultCallBack = "A Persistence Exception occurred";			
		}
		catch (Exception e) {
			logger.error("=============@create Exception================");
			logger.error(e.getMessage());
			resultCallBack = "A generic exception occured";
		}
		
		if (resultCallBack != null) {
			modelAndView.addObject("result", resultCallBack);
			modelAndView.addObject("shoppingNote", shoppingNote);
		} else {
			modelAndView = new ModelAndView("redirect:dispActive");
		}		
		
		return modelAndView;
	}

	//TODO
	/*
	@RequestMapping(value = { "/addForm" })
	public String getSearchResultViaAjax(@RequestBody ShoppingNote shoppingNote) {
		shoppingNoteService.update(shoppingNote);
		return "modelAndView";
	}
	*/
}