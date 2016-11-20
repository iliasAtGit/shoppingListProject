package com.iliasAtGit.shoppingListProject.controller;

import javax.persistence.PersistenceException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iliasAtGit.shoppingListProject.exception.InvalidRequestException;
import com.iliasAtGit.shoppingListProject.model.ShopDepartment;
import com.iliasAtGit.shoppingListProject.service.ShopDepartmentService;
import com.iliasAtGit.shoppingListProject.validator.ShopDepartmentValidator;


@RestController
@RequestMapping("/shopDepartment")
public class ShopDepartmentController {
	@Autowired
	private ShopDepartmentService shopDepartmentService;

	@Autowired
	private ShopDepartmentValidator shopDepartmentValidator;

	private static final Logger logger = LoggerFactory.getLogger(ShopDepartmentController.class);


	@RequestMapping(value = { "/display" }, method = RequestMethod.GET)
	public ModelAndView findAll(ModelAndView modelAndView) {
		modelAndView.addObject("shopDepartments", shopDepartmentService.findAll());
		return modelAndView;
	}

	@RequestMapping(value = { "/addForm" }, method = RequestMethod.GET)
	public ModelAndView create(ModelAndView modelAndView) {
		modelAndView.addObject("shopDepartment", new ShopDepartment());
		return modelAndView;

	}

	@RequestMapping(value = { "/addForm" }, method = RequestMethod.POST)
	public ModelAndView create(@Valid ShopDepartment shopDepartment,
			BindingResult result,
			ModelAndView modelAndView,
			RedirectAttributes redir) {

		shopDepartmentValidator.validate(shopDepartment, result);
		if (result.hasErrors())
			return modelAndView;

		String resultCallBack = null;

		try {
			shopDepartmentService.save(shopDepartment);
		} catch (DataIntegrityViolationException dive) {
			resultCallBack = Utils.filterException(logger, dive, dive.getRootCause().toString());
		} catch(PersistenceException pe){
			resultCallBack = Utils.filterException(logger, pe, pe.getCause().getCause().toString());
		} catch (Exception e) {
			logger.error(e.getMessage());
			resultCallBack = "An exception occured";
		} finally {
			if (resultCallBack != null) {
				modelAndView.addObject("result", resultCallBack);
				modelAndView.addObject("resultClass", "has-error");
				logger.error("============= Exceptions@create================");
			} else {
				modelAndView = new ModelAndView("redirect:display");
			}
		}

		return modelAndView;
	}

	@RequestMapping(value = { "/removeAjax-{id}" }, method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String deleteAjax(@PathVariable String id) {
		String resultCallBack = "success";

		try {
			shopDepartmentService.remove(new Short(id));
		} catch (DataIntegrityViolationException dive) {
			resultCallBack = Utils.filterException(logger, dive, dive.getRootCause().toString());
		} catch(PersistenceException pe){
			resultCallBack = Utils.filterException(logger, pe, pe.getCause().getCause().toString());
		} catch (Exception e) {
			logger.error(e.getMessage());
			resultCallBack = "A generic exception occured";
		} finally {
			if (!resultCallBack.equals("success"))
				logger.error("=============Exceptions@deleteAjax================");
		}

		return "{\"serversResponse\":\""+ resultCallBack +"\"}";
	}


	@RequestMapping(value = { "/updateAjax-{id}" }, method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String editAjax(@PathVariable String id,
			@Valid @RequestBody ShopDepartment shopDepartment,
			BindingResult bindingResult) {

		shopDepartmentValidator.validate(shopDepartment, bindingResult);

		if (bindingResult.hasErrors()) {
			throw new InvalidRequestException("Invalid update", bindingResult);
		}

		String resultCallBack = "success";

		try {
			shopDepartmentService.update(shopDepartment);
		} catch (DataIntegrityViolationException dive) {
			resultCallBack = Utils.filterException(logger, dive, dive.getRootCause().toString());
		} catch(PersistenceException pe){
			resultCallBack = Utils.filterException(logger, pe, pe.getCause().getCause().toString());
		} catch (Exception e) {
			logger.error(e.getMessage());
			resultCallBack = "A generic exception occured";
		} finally {
			if (!resultCallBack.equals("success"))
				logger.error("=============Exceptions@editAjax================");
		}

		return "{\"serversResponse\":\""+ resultCallBack +"\"}";
	}
}
