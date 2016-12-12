package com.quadcore.chat.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.quadcore.chat.model.User;
import com.quadcore.chat.model.UserRole;
import com.quadcore.chat.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		final User user = userRepository.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username + " not found.");
		}
	
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		
		for (UserRole role : user.getUserRoles())
		{
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().getRoleName()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}
}
