package com.ninexlabs.lgdp.usermodule.controllers;

import com.ninexlabs.lgdp.commons.models.UserDetails;
import com.ninexlabs.lgdp.usermodule.models.User;
import com.ninexlabs.lgdp.usermodule.services.UserService;
import com.ninexlabs.lgdp.usermodule.services.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = VersionService.BASE_PATH)
public class UserController
{
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userRepository)
	{
		this.userService = userRepository;
	}
	
	/**
	 * Show all users
	 *
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "")
	public Iterable index()
	{
		return this.userService.all();
	}
	
	/**
	 * Show a user
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "{id}")
	public ResponseEntity<UserDetails> show(@PathVariable long id)
	{
		UserDetails userDetails = this.userService.get(id);
		
		return new ResponseEntity<>(userDetails, HttpStatus.OK);
	}
	
	/**
	 * Store a new user in the database
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, path = "")
	public ResponseEntity<UserDetails> store(@RequestBody @Valid UserDetails request)
	{
		UserDetails userDetails = this.userService.store(request);
		
		return new ResponseEntity<>(userDetails, HttpStatus.CREATED);
	}
	
	/**
	 * Update the given user
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PATCH, path = "{id}")
	public ResponseEntity<UserDetails> update(@PathVariable("id") UserDetails targetUser, @RequestBody User request)
	{
		
		UserDetails userDetails = this.userService.update(targetUser);
		
		return new ResponseEntity<>(userDetails, HttpStatus.OK);
	}
	
	/**
	 * Delete a user when id is provided
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
	public ResponseEntity<Void> destroy(@PathVariable("id") Integer id)
	{
		this.userService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * UTIL Methods
	 */
	
	
	/**
	 * Find a user by email or password
	 *
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserDetails> findUserByEmailOrUsername(@RequestParam("username") String username)
	{
		
		UserDetails user = this.userService.findUserByUsername(username);
		
		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
		
	}
	
}
