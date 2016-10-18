package com.quadcore.chat.config;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			//.antMatchers("/css/**//*index//").permitAll() //requests matched againsts /css, & /index are fully accessible
			//.antMatchers("/user/**").hasRole("USER") //requests matched against /user/** require a user to be auth'd and must be associated to the USER role
			//.and()
			//.formLogin() //form-based authentication is enabled w/ a custom login page & failure url
			//.loginPage("/login").failureUrl("/login?error=true"); //user fails to login
	}
	
	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication()
			.withUser("user").password("password").roles("USER");
	}*/
//}
