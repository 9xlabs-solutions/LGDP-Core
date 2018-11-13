package com.ninexlabs.lgdp.usermodule.repositories;

import com.ninexlabs.lgdp.usermodule.models.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {


    Optional<Role> findRoleByName(String name);

}
