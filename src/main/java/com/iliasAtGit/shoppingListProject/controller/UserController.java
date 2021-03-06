package com.iliasAtGit.shoppingListProject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iliasAtGit.shoppingListProject.model.User;
import com.iliasAtGit.shoppingListProject.service.SecurityService;
import com.iliasAtGit.shoppingListProject.service.UserService;
import com.iliasAtGit.shoppingListProject.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = "/admin/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "admin/registration";
	}
	//-------------------Create a User--------------------------------------------------------
	@RequestMapping(value = "/admin/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm,
			BindingResult bindingResult,Model model) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "admin/registration";
		}

		userService.save(userForm);

		securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

		return "redirect:/welcome";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcome(Model model, HttpServletRequest request) {
		return "welcome";
	}

	@RequestMapping(value = "/admin/usertest", method = RequestMethod.GET)
    public String getIndexPage() {
        return "admin/user/UserManagement";
    }
}
