package com.quadcore.chat.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*Does not work atm.. */
@Controller
public class LoginController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/login")
	public ModelAndView login(@RequestParam Optional<String> error)
	{
		logger.debug("Getting login page, error={}", error);
		//logger.info("Login method has been invoked!");
		//logger.warn("This is a warning message.");
		//logger.error("This is an error message.");
		return new ModelAndView("login", "error", error);
	}
	
	@PostMapping("/login")
	public String loginSuccess()
	{
		return "redirect:/";
	}
}

