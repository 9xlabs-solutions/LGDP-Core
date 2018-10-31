package com.ninexlabs.lgdp.usermodule.models;

import com.ninexlabs.lgdp.commons.models.BaseModel;
import com.ninexlabs.lgdp.commons.models.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity(name = "users")
public class User extends BaseModel
{
	
	@NotNull(message = "Name cannot be empty")
	@Size(min = 3, max = 10)
	private String name;
	
	@Email
	@NotNull
	private String email;
	
	private String contact;
	
	private String address;
	
	private boolean isActive;
	
	@ManyToMany
	@JoinTable(name = "users_roles",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Collection<Role> roles;
	
	
	@ManyToMany
	@JoinTable(name = "user_permissions",
			joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
	private Collection<Permission> permissions;
	
	public User()
	{
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
	
	public String getContact()
	{
		return contact;
	}
	
	public void setContact(String contact)
	{
		this.contact = contact;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public boolean isActive()
	{
		return isActive;
	}
	
	public void setActive(boolean active)
	{
		isActive = active;
	}
	
	public Collection<Role> getRoles()
	{
		return roles;
	}
	
	public void setRoles(Collection<Role> roles)
	{
		this.roles = roles;
	}
	
	public Collection<Permission> getPermissions()
	{
		return permissions;
	}
	
	public void setPermissions(Collection<Permission> permissions)
	{
		this.permissions = permissions;
	}
	
	public UserDetails getUserDetails()
	{
		UserDetails userDetails = new UserDetails();
		
		userDetails.setId(this.getId());
		userDetails.setName(this.getName());
		userDetails.setEmail(this.getEmail());
		userDetails.setAddress(this.getAddress());
		userDetails.setCreated_at(this.getCreated_at());
		userDetails.setUpdated_at(this.getUpdated_at());
		
		return userDetails;
	}
}
