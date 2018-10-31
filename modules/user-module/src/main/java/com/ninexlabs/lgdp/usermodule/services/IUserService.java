package com.ninexlabs.lgdp.usermodule.services;

import com.ninexlabs.lgdp.commons.models.UserDetails;
import com.ninexlabs.lgdp.usermodule.models.User;

import java.util.Optional;

public interface IUserService
{
	
	Iterable<UserDetails> all();
	
	UserDetails get(long id);
	
	UserDetails store(UserDetails user);
	
	UserDetails update(UserDetails user);
	
	void delete(long id);

}
