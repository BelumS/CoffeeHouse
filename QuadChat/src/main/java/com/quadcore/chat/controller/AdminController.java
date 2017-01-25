package com.quadcore.chat.controller;

import javax.validation.Valid;

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
 * The Spring MVC controller that maps the HTTP requests for the Admin page
 * <p>
 * @author Quadcore
 * @since 12/26/16
 * @Version 1.0
 * @category Spring MVC - Controller
 * @see admin.html
 * {@link src/main/resources/templates/admin.html}
 */
@Controller
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/admin")
	public String displayAdminPage(@ModelAttribute("user") User user, Model model)
	{
		model.addAttribute("user", new User());
		return "admin";
	}
	
	@PostMapping("/admin")
	public String submitUserForm(@Valid @ModelAttribute("user") User user, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			return "admin?error";
		}
		else if(userService.findByUsername(user.getUsername()))
		{
			model.addAttribute("message", "Username already exists. Try another username.");
			return "admin?error";
		}
		else
		{
			userService.save(user);
			model.addAttribute("message", "Saved user details");
			return "results";
		}
	}

}
