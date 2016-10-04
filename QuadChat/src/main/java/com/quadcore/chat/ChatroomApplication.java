package com.quadcore.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //combination of @Configuration, @EnableAutoConfiguration, @EnableWebMvc, and @ComponentScan
public class ChatroomApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(ChatroomApplication.class, args);
	}
}
