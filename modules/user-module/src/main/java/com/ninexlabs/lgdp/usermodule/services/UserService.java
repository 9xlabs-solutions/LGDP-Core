package com.ninexlabs.lgdp.usermodule.services;

import com.ninexlabs.lgdp.usermodule.models.User;
import com.ninexlabs.lgdp.usermodule.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService implements IUserService
{
	
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
	
	@Override
	public Iterable<User> all()
	{
		return this.userRepository.findAll();
	}
	
	@Override
	public Optional<User> get(long id)
	{
		return this.userRepository.findById(id);
	}
	
	@Override
	public synchronized User store(User user)
	{
		return this.userRepository.save(user);
	}
	
	@Override
	public synchronized User update(User user)
	{
		// get the user
		Optional<User> usero = get(user.getId());
		
		// delete only if the object exists
		if (usero.isPresent())
		{
			return this.userRepository.save(usero.get());
		}
		
		return null;
	}
	
	@Override
	public void delete(long id)
	{
		
		// get the user
		Optional<User> user = get(id);
		
		// delete only if the object exists
		if (user.isPresent())
		{
			this.userRepository.delete(user.get());
		}
		
	}
}
