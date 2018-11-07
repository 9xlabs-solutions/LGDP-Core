package com.ninexlabs.lgdp.apigateway.security;

import com.ninexlabs.lgdp.commons.models.UserModelDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.RestTemplate;

public class CustomUserService implements UserDetailsService
{
	
	private RestTemplate restTemplate;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		
		String URL = "http://localhost:1026/api/users/v1/";
		
		this.restTemplate = new RestTemplate();
		
		UserModelDetails user = restTemplate
				.getForObject(URL, UserModelDetails.class);
		
		if (user == null)
		{
			throw new UsernameNotFoundException("Username not found");
		}
		
		return UserPrincipal.create(user);

	}
}
