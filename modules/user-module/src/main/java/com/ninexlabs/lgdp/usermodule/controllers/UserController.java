package com.ninexlabs.lgdp.usermodule.controllers;

import com.ninexlabs.lgdp.usermodule.models.User;
import com.ninexlabs.lgdp.usermodule.services.UserService;
import com.ninexlabs.lgdp.usermodule.services.VersionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
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
	public User show(@PathVariable long id)
	{
		return this.userService.get(id).orElse(null);
	}
	
	/**
	 * Store a new user in the database
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, path = "")
	public ResponseEntity store(@RequestBody @Valid User request, Errors err)
	{
		
		if (err.hasErrors())
		{
			return new ResponseEntity<>(err.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		
		return ResponseEntity.ok().build();
//
//		User user = new User();
//
//		BeanUtils.copyProperties(request, user);
//
//		user = this.userService.store(user);
//
//		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	/**
	 * Update the given user
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PATCH, path = "{id}")
	public ResponseEntity<User> update(@PathVariable("id") User targetUser, @RequestBody User request)
	{
		
		BeanUtils.copyProperties(request, targetUser, "id", "created_at");
		
		User user = this.userService.update(targetUser);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
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
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
