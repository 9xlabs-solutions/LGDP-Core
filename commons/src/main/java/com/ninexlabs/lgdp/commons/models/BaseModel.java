package com.ninexlabs.lgdp.commons.models;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseModel
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	// created at and updated and fields
	@Column(updatable = false)
	private Date created_at;
	
	private Date updated_at;
	
	@PrePersist
	public void setCreatedAtAndUpdatedAt()
	{
		
		// create a date object
		Date date = new Date();
		
		this.created_at = date;
		
		this.updated_at = date;
	}
	
	@PreUpdate
	public void setUpdatedAt()
	{
		this.updated_at = new Date();
	}
	
	public long getId()
	{
		return id;
	}
	
	public Date getCreated_at()
	{
		return created_at;
	}
	
	public void setCreated_at(Date created_at)
	{
		this.created_at = created_at;
	}
	
	public Date getUpdated_at()
	{
		return updated_at;
	}
	
	public void setUpdated_at(Date updated_at)
	{
		this.updated_at = updated_at;
	}
}
