package com.ninexlabs.lgdp.commons.models;

import java.util.Collection;
import java.util.Date;

public class UserDetails extends BaseModelDetails
{
	
	private String name, email, address, phone;
	
	private String username;
	
	private String password;
	
	private Date dob;
	
	private Collection<Role> roles, permission;
	
	
	public UserDetails()
	{
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public Date getDob()
	{
		return dob;
	}
	
	public void setDob(Date dob)
	{
		this.dob = dob;
	}
	
	public Collection<Role> getRoles()
	{
		return roles;
	}
	
	public void setRoles(Collection<Role> roles)
	{
		this.roles = roles;
	}
	
	public Collection<Role> getPermission()
	{
		return permission;
	}
	
	public void setPermission(Collection<Role> permission)
	{
		this.permission = permission;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
}
