package com.iliasAtGit.helloMVC.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iliasAtGit.helloMVC.model.Product;
import com.iliasAtGit.helloMVC.service.ProductService;

// TODO: Auto-generated Javadoc
/**
 * Handles requests for the application home page.
 */

@Controller
public class HelloMVCCOntroller {

	/** The product service. */
	@Autowired
	private ProductService productService;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(HelloMVCCOntroller.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 *
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @return the string
	 * 
	 * 
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.info("In log4j.xml file you can change the logging level from INFO to DEBUG , to see more logging info");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	/*
	 * http://stackoverflow.com/questions/9450413/spring-redirect-not-working
	 * 
	 * @RequestMapping(value = { "/addProdForm", "/addProductHref"}, method =
	 * RequestMethod.GET) public String newProduct(ModelMap model) {
	 * 
	 * model.addAttribute("product", new Product()); model.addAttribute("edit",
	 * false); return "redirect:/addProdForm"; }
	 */

	/*
	 * @RequestMapping(value = { "/addProdForm" }, method = RequestMethod.POST)
	 * public String saveProduct(@Valid Product product, BindingResult result,
	 * ModelMap model) { System.out.println(
	 * "++++++++++++++Product saveProduct POST++++++++++++++"); if
	 * (result.hasErrors()) { return "addProdForm"; } model.addAttribute("edit",
	 * true); productService.add(product); System.out.println("Product " +
	 * product.getId() + "=" + product.getName()); model.addAttribute("success",
	 * "Product " + product.getId() + "=" + product.getName()); return
	 * "redirect:/prodDisplay"; }
	 */

}
