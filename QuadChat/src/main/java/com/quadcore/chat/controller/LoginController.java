package com.quadcore.chat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*Does not work atm.. */
@Controller
public class LoginController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/login")
	public String login()
	{
		//logger.debug("This is a debug message.");
		logger.info("Login method has been invoked!");
		//logger.warn("This is a warning message.");
		//logger.error("This is an error message.");
		return "login";
	}
}
