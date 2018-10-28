package com.ninexlabs.lgdp.usermodule.controllers;

import com.ninexlabs.lgdp.usermodule.repositories.UserRepository;
import com.ninexlabs.lgdp.usermodule.services.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = VersionService.BASE_PATH)
public class UserController
{
	
	private UserRepository userRepository;
	
	@Autowired
	public UserController(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "")
	public Iterable index()
	{
		return this.userRepository.findAll();
	}
	
}
