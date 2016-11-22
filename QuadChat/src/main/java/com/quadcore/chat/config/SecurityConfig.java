package com.quadcore.chat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{	
		http.authorizeRequests()
		.antMatchers("/register").permitAll()
		.antMatchers("/", "/chat").access("hasAnyRole('USER', 'ADMIN')")
		.antMatchers("/admins/**").access("hasRole('ADMIN')")
			.and()
		.formLogin()
		.loginPage("/login")
		//.defaultSuccessUrl("/", true)
		.failureUrl("/login?error")
		.permitAll()
			.and()
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/login?logout")
		.permitAll()
			.and()
		.exceptionHandling().accessDeniedPage("/errors/403");
	}
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.inMemoryAuthentication()
			.withUser("user").password("password").roles("USER")
		.and()
			.withUser("admin").password("password").roles("USER, ADMIN");
	}

	
}