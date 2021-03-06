package com.quadcore.chat.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.quadcore.chat.model.LoginForm;
import com.quadcore.chat.service.UserService;

/**
 * The Spring MVC controller that maps the HTTP requests for the Login page
 * <p>
 * @author Quadcore
 * @since 10/16/16
 * @Version 1.0
 * @category Spring MVC Controller
 * @see login.html
 * {@linkplain src/main/resources/templates/login.html}
 */
@Controller
public class LoginController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/login")
	public String displayLoginPage(@ModelAttribute("loginForm") LoginForm loginForm, Model model)
	{
		logger.debug("Getting login page");
		model.addAttribute("studentLogin", new LoginForm());
		return "login";
	}
	
	@PostMapping("/login")
	public String executeLogin(@Valid LoginForm loginForm, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors()) {
			return "login?error=true";
		}
		return "redirect:/";
	}
	
	@PostMapping("/logout")
	public String executeLogout()
	{
		return "/login?logout=true";
	}
}