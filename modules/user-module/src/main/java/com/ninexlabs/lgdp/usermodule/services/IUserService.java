package com.ninexlabs.lgdp.usermodule.services;

import com.ninexlabs.lgdp.usermodule.models.User;

import java.util.Optional;

public interface IUserService
{
	
	Iterable<User> all();
	
	Optional<User> get(long id);
	
	User store(User user);
	
	User update(User user);
	
	void delete(long id);

}
