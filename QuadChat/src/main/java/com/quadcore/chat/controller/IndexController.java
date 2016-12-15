package com.quadcore.chat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The Spring MVC controller that maps the HTTP requests for the main page
 * <p>
 * @author Quadcore
 * @Version 1.0
 * @since 10/14/16
 * @category Spring MVC Controller
 * @see index.html
 * {@link src/main/resources/templates/index.html}
 */
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
