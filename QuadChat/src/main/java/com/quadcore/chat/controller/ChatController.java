package com.quadcore.chat.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quadcore.chat.dto.Message;
import com.quadcore.chat.dto.OutputMessage;

/**
 * The Spring MVC controller that maps the HTTP requests for the Chatroom page
 * <p>
 * @author Quadcore
 * @since 10/14/16
 * @Version 1.0
 * @category Spring MVC - Controller
 * @see chat.html
 * {@link src/main/resources/templates/chat.html}
 */
@Controller
public class ChatController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/chat")
	public String getChatPage()
	{
		logger.debug("Getting Chatroom page");
		return "chat";
	}
	
	@MessageMapping("/chat")
	@SendTo("/topic/message")
	public OutputMessage sendMessage(Message message)
	{
		return new OutputMessage(message, new Date());
	}

}
