package com.quadcore.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	//@Autowired
	//private UserService userService;
	
	@GetMapping("/admin")
	public String displayAdminPage()
	{
		return "/admin";
	}

}
