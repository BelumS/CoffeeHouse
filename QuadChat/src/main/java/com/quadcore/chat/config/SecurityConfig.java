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
			.antMatchers("/login", "/register", "/registration-test").permitAll()
			.antMatchers("/","/chat").access("hasRole('USER')")
			.antMatchers("/admin").access("hasRole('ADMIN')")
			.and()
		.formLogin().loginPage("/login")
			.usernameParameter("username").passwordParameter("password")
            .defaultSuccessUrl("/chat")
			.failureUrl("/login?error=true")
			.permitAll()
			.and()
		.logout()
			.logoutUrl("/login?logout")
			.logoutSuccessUrl("/login?logout")
		.and()
			.exceptionHandling().accessDeniedPage("/errors/403");
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication()
			.withUser("user").password("password").roles("USER")
			.and()
			.withUser("admin").password("password").roles("USER", "ADMIN");
	}
	
}