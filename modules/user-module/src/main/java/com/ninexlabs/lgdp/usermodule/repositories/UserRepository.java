package com.ninexlabs.lgdp.usermodule.repositories;

import com.ninexlabs.lgdp.commons.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long>
{
	
	/**
	 * Find a user by a username
	 *
	 * @return User
	 */
	Optional<User> findUserByUsernameAndIsActiveIsTrue(String username);
	
}
