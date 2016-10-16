package com.quadcore.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*Does not work atm.. */
@Controller
public class LoginController {

	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
}
