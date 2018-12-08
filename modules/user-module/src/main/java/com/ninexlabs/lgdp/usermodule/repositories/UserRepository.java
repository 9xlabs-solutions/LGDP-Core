package com.ninexlabs.lgdp.usermodule.repositories;

import com.ninexlabs.lgdp.usermodule.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Find a user by a username where the status is active
     *
     * @return User
     */
    Optional<User> findUserByUsernameAndIsActiveIsTrue(String username);

    /**
     * Find a user by his/her username
     *
     * @param username
     * @return
     */
    Optional<User> findUserByUsername(String username);

}
