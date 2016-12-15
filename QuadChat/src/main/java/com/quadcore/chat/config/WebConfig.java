package com.quadcore.chat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

/**
 * The file that configures the Spring MVC settings, to user preference
 * <p>
 * @author Quadcore
 * @since 10/4/16
 * @version 2.0
 * @see WebMvcConfigurerAdapter
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) 
	{
		registry.addViewController("/home").setViewName("index");
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/register").setViewName("register");
		registry.addViewController("/chat").setViewName("chat");
		registry.addViewController("/errors/403").setStatusCode(HttpStatus.FORBIDDEN);
		registry.addViewController("/admin").setViewName("admin");
		registry.addViewController("/results").setViewName("results");
	}
	
	@Bean
	public WebContentInterceptor webContentInterceptor()
	{
		WebContentInterceptor interceptor = new WebContentInterceptor();
		interceptor.setCacheSeconds(0);
		
		return interceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(webContentInterceptor());
	}
}
