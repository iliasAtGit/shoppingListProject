package com.iliasAtGit.shoppingListProject.controller;

import java.security.Principal;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iliasAtGit.shoppingListProject.dao.custom.ProductForUser;
import com.iliasAtGit.shoppingListProject.exception.InvalidRequestException;
import com.iliasAtGit.shoppingListProject.model.Product;
import com.iliasAtGit.shoppingListProject.model.User;
import com.iliasAtGit.shoppingListProject.service.CustomSecurityUser;
import com.iliasAtGit.shoppingListProject.service.ProductService;
import com.iliasAtGit.shoppingListProject.service.ShopDepartmentService;
import com.iliasAtGit.shoppingListProject.service.UnitService;
import com.iliasAtGit.shoppingListProject.validator.ProductUserValidator;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private ShopDepartmentService shopDepartmentService;

	@Autowired
	private UnitService unitService;

	@Autowired
	private ProductUserValidator productUserValidator;

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@InitBinder("product")
	public void dataBinding(WebDataBinder binder) {
		binder.addValidators(productUserValidator);
	}

	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public ModelAndView productHome(ModelAndView modelAndView) {
		modelAndView.setViewName("redirect:display");
		return modelAndView;
	}

	@RequestMapping(value = { "/display" }, method = RequestMethod.GET)
	public ModelAndView display(ModelAndView modelAndView) {
		modelAndView.addObject("products", productService.findAll4User());
		modelAndView.addObject("shopDeparts", shopDepartmentService.findAll());
		modelAndView.addObject("units", unitService.findAll());
		return modelAndView;
	}

	@RequestMapping(value = { "/addForm" }, method = RequestMethod.GET)
	public ModelAndView addForm(ModelAndView modelAndView, HttpServletRequest request) {
		modelAndView.addObject("product", new ProductForUser());
		modelAndView.addObject("shopDeparts", shopDepartmentService.findAll());
		modelAndView.addObject("units", unitService.findAll());
		return modelAndView;
	}

	@RequestMapping(value = { "/addForm" }, method = RequestMethod.POST)
	public ModelAndView addForm(@Valid Product product,
			  				    BindingResult result,
			  				    ModelAndView modelAndView,
							    RedirectAttributes redir,
							    HttpServletRequest request,
							    Exception exception,
							    Principal principal) {
		if (result.hasErrors()) {
			modelAndView.addObject("shopDeparts", shopDepartmentService.findAll());
			return modelAndView;
		}

		String resultCallBack = null;

		try {
			System.out.println("aaaa0a");
			CustomSecurityUser customSecurityUser = (CustomSecurityUser) ((Authentication) principal).getPrincipal();
			User user = new User();
			System.out.println("aaaa0b");
			user.setId(customSecurityUser.getId());
			product.setCreatedBy(user);
			System.out.println("aaaa0c");
			productService.save(product);
			System.out.println("aaaad");
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
				modelAndView.addObject("shopDeparts", shopDepartmentService.findAll());
				logger.error("============= Exceptions@create================");
			} else {
				modelAndView = new ModelAndView("redirect:display");
			}
		}
		System.out.println("aaaa2");
		return modelAndView;
	}

	@RequestMapping(value = { "/removeAjax-{id}" }, method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String removeAjax(@PathVariable String id) {
		String resultCallBack = "success";

		try {
			productService.remove(new Short(id));
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
	public String upateAjax(@PathVariable String id,
			                @Valid @RequestBody Product product,
						    BindingResult bindingResult) {
		productUserValidator.validate(product, bindingResult);

		if (bindingResult.hasErrors()) {
			throw new InvalidRequestException("Invalid update", bindingResult);
		}

		String resultCallBack = "success";

		try {
			productService.update(product);
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
