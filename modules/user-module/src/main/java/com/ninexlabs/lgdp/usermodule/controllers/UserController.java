package com.ninexlabs.lgdp.usermodule.controllers;

import com.ninexlabs.lgdp.commons.models.UserModelDetails;
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
	public ResponseEntity<UserModelDetails> show(@PathVariable long id)
	{
		UserModelDetails userModelDetails = this.userService.get(id);
		
		return new ResponseEntity<>(userModelDetails, HttpStatus.OK);
	}
	
	/**
	 * Store a new user in the database
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, path = "")
	public ResponseEntity<UserModelDetails> store(@RequestBody @Valid UserModelDetails request)
	{
		UserModelDetails userModelDetails = this.userService.store(request);
		
		return new ResponseEntity<>(userModelDetails, HttpStatus.CREATED);
	}
	
	/**
	 * Update the given user
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PATCH, path = "{id}")
	public ResponseEntity<UserModelDetails> update(@PathVariable("id") UserModelDetails targetUser, @RequestBody User request)
	{
		
		UserModelDetails userModelDetails = this.userService.update(targetUser);
		
		return new ResponseEntity<>(userModelDetails, HttpStatus.OK);
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
	
}
