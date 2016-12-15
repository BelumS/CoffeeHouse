package com.quadcore.chat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;

/**
 * The file that configures the Spring Security authentications using Java Annotations
 * <p>
 * @author Quadcore
 * @since 10/18/16
 * @version 2.0
 * @see WebSecurityConfigurerAdapter
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{	
		//Allows anyone to access register.html, and the h2 db console
		http.authorizeRequests().antMatchers("/register", "h2-console/**").permitAll();
	
		//Only authenticated users can access index/chat/admin.html
		http.authorizeRequests().antMatchers("/", "/chat").hasAnyRole("ADMIN","USER")
		.antMatchers("/admin").hasRole("ADMIN");
		
		//configure a customized login.html page
		http.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/", true)
		.failureUrl("/login?error")
		.permitAll()
			.and()
		//Setup the logging out functionality
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/login?logout")
		.permitAll()
			.and()
		//Setup the access denied page for invalid permissions
		.exceptionHandling().accessDeniedPage("/errors/403");
		
		//Specific developmental features to disable for the H2 web console
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		//Authenticate users from the database, and store their passwords with a special encoding
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	//inject the UserDetailsService
	@Override
	protected UserDetailsService userDetailsService()
	{
		return userDetailsService;
	}
	
	//Inject the Password encoder
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}