package com.quadcore.chat;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.quadcore.chat") //combination of @Configuration, @EnableAutoConfiguration, @EnableWebMvc, and @ComponentScan
//@ComponentScan("com.quadcore.chat")
//@EnableJpaRepositories(basePackages = "com.quadcore.chat")
public class ChatroomApplication {

	public static void main(String[] args) 
	{
		ApplicationContext context = SpringApplication.run(ChatroomApplication.class, args);
	
		/*System.out.println("Let's inspect the beans provided by Spring Boot:");
		
		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		
		for(String beanName : beanNames)
		{
			System.out.println(beanName);
		}*/
	}
}
