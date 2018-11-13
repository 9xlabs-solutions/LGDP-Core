package com.ninexlabs.lgdp.apigateway.security;

import com.ninexlabs.lgdp.commons.models.UserModelDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails
{
	
	private Long id;
	
	private String name;
	
	private String username;
	
	private String email;

	private String password;

	private boolean isActive;
	
	private String remember_token;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return authorities;
	}


	public UserPrincipal(Long id, String name, String username, String email, String password, boolean isActive, Collection<? extends GrantedAuthority> authorities)
	{
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
		this.isActive = isActive;
	}
	
	public static UserPrincipal create(UserModelDetails userModelDetails)
	{

		List<GrantedAuthority> authorities = new ArrayList<>();

		if (userModelDetails.getRoles() != null) {
			authorities = userModelDetails.getRoles().stream().map(role ->
					new SimpleGrantedAuthority(role.getName())
			).collect(Collectors.toList());
		}

		return new UserPrincipal(
				userModelDetails.getId(),
				userModelDetails.getName(),
				userModelDetails.getUsername(),
				userModelDetails.getEmail(),
				userModelDetails.getPassword(),
				userModelDetails.getIsActive(),
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
		return isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
