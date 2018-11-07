package com.ninexlabs.lgdp.apigateway.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ninexlabs.lgdp.commons.models.UserModelDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails
{
	
	private Long id;
	
	private String name;
	
	private String username;
	
	private String email;
	
	@JsonIgnore
	private String password;
	
	private String remember_token;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return null;
	}
	
	
	public UserPrincipal(Long id, String name, String username, String email, String password, Collection<? extends GrantedAuthority> authorities)
	{
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}
	
	public static UserPrincipal create(UserModelDetails userModelDetails)
	{
		List<GrantedAuthority> authorities = userModelDetails.getRoles().stream().map(role ->
				new SimpleGrantedAuthority(role.getName())
		).collect(Collectors.toList());
		
		return new UserPrincipal(
				userModelDetails.getId(),
				userModelDetails.getName(),
				userModelDetails.getUsername(),
				userModelDetails.getEmail(),
				userModelDetails.getPassword(),
				authorities
		);
	}
	
	@Override
	public String getPassword()
	{
		return this.password;
	}
	
	@Override
	public String getUsername()
	{
		return this.username;
	}
	
	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}
	
	@Override
	public boolean isEnabled()
	{
		return true;
	}
}
