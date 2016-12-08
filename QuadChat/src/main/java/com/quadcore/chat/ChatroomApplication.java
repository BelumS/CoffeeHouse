package com.quadcore.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication //combination of @Configuration, @EnableAutoConfiguration, @EnableWebMvc, and @ComponentScan
@ComponentScan("com.quadcore.chat")
@EnableJpaRepositories(basePackages = "com.quadcore.chat")
public class ChatroomApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(ChatroomApplication.class, args);
	}
}
