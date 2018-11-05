package com.ninexlabs.lgdp.usermodule.principles;

import com.ninexlabs.lgdp.usermodule.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserPrincipal extends com.ninexlabs.lgdp.commons.models.UserDetails implements UserDetails
{
	
	private User user;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	UserPrincipal(User user, Collection<? extends GrantedAuthority> authorities)
	{
		this.user = user;
		
		this.authorities = authorities;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return null;
	}
	
	@Override
	public String getPassword()
	{
		return null;
	}
	
	@Override
	public String getUsername()
	{
		return null;
	}
	
	@Override
	public boolean isAccountNonExpired()
	{
		return false;
	}
	
	@Override
	public boolean isAccountNonLocked()
	{
		return false;
	}
	
	@Override
	public boolean isCredentialsNonExpired()
	{
		return false;
	}
	
	@Override
	public boolean isEnabled()
	{
		return false;
	}
}
