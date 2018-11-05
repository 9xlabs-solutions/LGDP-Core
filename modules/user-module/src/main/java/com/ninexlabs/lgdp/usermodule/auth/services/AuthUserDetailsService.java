package com.ninexlabs.lgdp.usermodule.auth.services;

import com.ninexlabs.lgdp.usermodule.models.User;
import com.ninexlabs.lgdp.usermodule.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthUserDetailsService implements UserDetailsService
{
	
	private final UserRepository userRepository;
	
	@Autowired
	public AuthUserDetailsService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
 		Optional<User> userOptional = this.userRepository.findUserByUsernameAndActiveIsTrue(username);
 		
 		return null;
	}
}
