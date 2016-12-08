package com.quadcore.chat.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.quadcore.chat.model.User;
import com.quadcore.chat.model.UserRole;
import com.quadcore.chat.repository.UserRepository;

@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepository;
	
	public UserDetailsServiceImpl(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		try {
			User user = userRepository.findByUsername(username);
			
			if(user == null) {
				throw new UsernameNotFoundException("User: " + username + " not found");
			}
				
			org.springframework.security.core.userdetails.User userSecurity = 
					new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
			
			return userSecurity;
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("User not found");
		}
	}

	private Set<GrantedAuthority>getAuthorities(User user) 
	{
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();  
        for(UserRole role : user.getUserRoles()) {  
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getUserRoleName());  
            authorities.add(grantedAuthority);  
        }    
        return authorities;  
	}

}
