package com.quadcore.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.quadcore.chat.model.Greeting;
import com.quadcore.chat.model.HelloMessage;

//a Controller to receive the hello message, and send the greeting message

@Controller
public class GreetingController {
	
	//The payload of the message is bound to a HelloMessage object which is passed into greeting().
	@MessageMapping("/com/quadcore/chat/") //invokes the greeting() method, when a message is sent to /hello
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception
	{
		Thread.sleep(1000); //simulated delay
		
		//After the 1 second delay, the greeting() method creates a Greeting object and
		//returns it. 
		return new Greeting("Hello, " + message.getName() + "!");
		//The return value is broadcast to all subscribers to "/topic/greetings"
		//as specified in @SendTo
	}
}
