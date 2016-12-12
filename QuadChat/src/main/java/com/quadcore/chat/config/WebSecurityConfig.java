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

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{	
		http.authorizeRequests()
		.antMatchers("/register").permitAll()
		.and().authorizeRequests().antMatchers("/h2-console/**").permitAll()
		.antMatchers("/", "/chat").hasAnyRole("ADMIN","USER")
		.antMatchers("/admin").hasRole("ADMIN")
			.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/", true)
		.failureUrl("/login?error")
		.permitAll()
			.and()
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/login?logout")
		.permitAll()
			.and()
		.exceptionHandling().accessDeniedPage("/errors/403");
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
		/*auth.inMemoryAuthentication()
			.withUser("user").password("password").roles("USER")
		.and()
			.withUser("admin").password("password").roles("ADMIN");*/
	}
	
	@Override
	protected UserDetailsService userDetailsService()
	{
		return userDetailsService;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}