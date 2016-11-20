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
	protected void configure(HttpSecurity http) throws Exception {
		/*//This page does not require login
		http.authorizeRequests().antMatchers("/login");
		
		//main page requires login as USER or ADMIN
		http.authorizeRequests().antMatchers("/").access("hasAnyRole('USER', 'ADMIN')");
	
		//For admin only
		
		//When user has loggin in as XX,
		//but accesses a page the requires role YY
		//AccessDeniedException will throw.
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
		
		//Config for Login Form
		http.authorizeRequests().and().formLogin()
			//Submit url of login page
			//.loginProcessingUrl("j_spring_security_check")
			.loginPage("/login")
			.defaultSuccessUrl("/")
			.failureUrl("/login?error=true")
			.usernameParameter("username")
			.passwordParameter("password")
			//Config for logout page
			.and().logout().logoutUrl("/logout").logoutSuccessUrl("/logout");	
			*/
		
		http.authorizeRequests()
			.antMatchers("/", "/chat").access("hasAnyRole('USER, ADMIN')")
			.antMatchers("/register", "/static/**").permitAll()
			.anyRequest().fullyAuthenticated()
			.and()
		.formLogin().loginPage("/login")
			.usernameParameter("username").passwordParameter("password")
			.failureUrl("/login?error")
			.permitAll()
			.and()
		.logout()
			.logoutUrl("/login?logout")
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