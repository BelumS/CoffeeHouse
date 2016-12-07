package com.quadcore.chat.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.quadcore.chat.model.Role;
import com.quadcore.chat.model.User;
import com.quadcore.chat.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		try {
			User user = userRepository.findByUsername(username);
			
			if(user == null)
				throw new UsernameNotFoundException("User not found");
			
			Role role = (Role) user.getUserRoles();
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
				authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName().toUpperCase()));
			
			org.springframework.security.core.userdetails.User userSecurity = 
					new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
			
			return userSecurity;
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("User not found");
		}
	}

}
