package com.quadcore.chat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping({"/", "/home"})
	public String index()
	{
		logger.debug("Getting home page");
		return "index";
	}
}
