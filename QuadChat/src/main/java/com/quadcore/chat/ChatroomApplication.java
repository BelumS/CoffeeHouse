package com.quadcore.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The class the bootstraps the Spring Boot Application
 * <p>
 * @author Quadcore
 * @version 1.0
 * @since 10/4/16
 * @see SpringApplication
 * 
 */
@SpringBootApplication(scanBasePackages = "com.quadcore.chat") //combination of @Configuration, @EnableAutoConfiguration, @EnableWebMvc, and @ComponentScan
public class ChatroomApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(ChatroomApplication.class, args);
	
		/*System.out.println("Let's inspect the beans provided by Spring Boot:");
		
		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		
		for(String beanName : beanNames)
		{
			System.out.println(beanName);
		}*/
	}
}
