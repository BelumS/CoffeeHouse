package com.quadcore.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
	
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	
	/*@PostMapping("/register")
	public String registeredCredentials()
	{
		return "register";
	}*/
	
}
