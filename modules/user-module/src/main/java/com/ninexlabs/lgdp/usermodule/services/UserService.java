package com.ninexlabs.lgdp.usermodule.services;

import com.ninexlabs.lgdp.commons.LGDPException;
import com.ninexlabs.lgdp.commons.models.UserDetails;
import com.ninexlabs.lgdp.usermodule.models.User;
import com.ninexlabs.lgdp.usermodule.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class UserService implements IUserService
{
	
	// user repository
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
	
	@Override
	public Iterable<UserDetails> all()
	{
		
		Iterable<User> users = this.userRepository.findAll();
		
		Iterable<UserDetails> formattedUserDetails = new ArrayList<>();
		
		for(User user: users)
		{
			((ArrayList<UserDetails>) formattedUserDetails).add(user.getUserDetails());
		}
		
		return formattedUserDetails;
	}
	
	@Override
	public UserDetails get(long id)
	{
		
		User user = this.userRepository.findById(id).orElse(null);
		
		if (user != null)
		{
			return user.getUserDetails();
		}
		
		return null;
		
	}
	
	@Override
	public synchronized UserDetails store(UserDetails details)
	{
		return updateOrSaveUser(details);
	}
	
	@Override
	public synchronized UserDetails update(UserDetails details)
	{
		return updateOrSaveUser(details);
	}
	
	@Override
	public void delete(long id)
	{
		this.userRepository.deleteById(id);
	}
	
	/**
	 * Add or update user details
	 *
	 * @param details
	 * @return
	 */
	private UserDetails updateOrSaveUser(UserDetails details)
	{
		if (details == null)
		{
			throw new LGDPException(LGDPException.ExceptionType.INVALID_DATA_EXCEPTION, "No User Details");
		}
		
		User user = new User();
		
		BeanUtils.copyProperties(details, user);
		
		user = this.userRepository.save(user);
		
		BeanUtils.copyProperties(user, details);
		
		return details;
	}
	
}
