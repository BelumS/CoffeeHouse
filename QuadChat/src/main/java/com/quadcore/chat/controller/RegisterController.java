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
import com.quadcore.chat.model.User;
import com.quadcore.chat.service.UserService;

/**
 * The Spring MVC controller that maps the HTTP requests for the Registration page
 * <p>
 * @author Quadcore
 * @since 10/27/16
 * @Version 1.0
 * @category Spring MVC Controller
 * @see register.html
 * {@link src/main/resources/templates/register.html}
 * <p>
 * {@link src/main/resources/templates/results.html}
 */
@Controller
public class RegisterController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String registerForm(@ModelAttribute("user") User user, Model model)
	{
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String submitRegisterForm(@Valid @ModelAttribute("user") User user, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			return "register?error";
		}
		else if(userService.findByUsername(user.getUsername()))
		{
			model.addAttribute("message", "Username already exists. Try another username.");
			return "register?error";
		}
		else
		{
			userService.save(user);
			model.addAttribute("message", "Saved user details");
			return "results";
		}
	}
}
