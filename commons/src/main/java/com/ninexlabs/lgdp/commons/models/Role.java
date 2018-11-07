package com.ninexlabs.lgdp.commons.models;

import javax.persistence.Entity;

@Entity(name = "roles")
public class Role extends BaseModel
{

	private String name;

	private String description;

	public Role()
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

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}
