package com.ninexlabs.lgdp.usermodule.repositories;

import com.ninexlabs.lgdp.usermodule.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
	
//	/**
//	 * Get all non active users
//	 *
//	 * @return
//	 */
//	public Iterable<User> findAllByIsActiveIsTrue();
//
//	/**
//	 * Get all active users
//	 *
//	 * @return
//	 */
//	public Iterable<User> findAllByActiveIsFalse();
	
}
