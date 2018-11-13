package com.ninexlabs.lgdp.usermodule.services;

import com.ninexlabs.lgdp.commons.LGDPException;
import com.ninexlabs.lgdp.commons.models.RoleModelDetails;
import com.ninexlabs.lgdp.usermodule.models.Role;
import com.ninexlabs.lgdp.usermodule.repositories.RoleRepository;
import com.ninexlabs.lgdp.usermodule.services.interfaces.IRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RoleService implements IRoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleModelDetails> index() {

       Iterable<Role> roles = this.roleRepository.findAll();

       List<RoleModelDetails> roleModelDetails = new ArrayList<>();

        for (Role role : roles) {
            roleModelDetails.add(role.getRoleModelDetails());
        }

        return roleModelDetails;
    }

    @Override
    public RoleModelDetails show(Long id) {

        Optional<Role> role = this.roleRepository.findById(id);

        if (!role.isPresent())
        {
            throw new LGDPException(LGDPException.ExceptionType.RESOURCE_DOES_NOT_EXISTS, "Role does not exists");
        }

        return role.get().getRoleModelDetails();
    }

    @Override
    public RoleModelDetails store(RoleModelDetails details) {

        Optional<Role> roleOptional = this.roleRepository.findRoleByName(details.getName());

        if (roleOptional.isPresent()) {
            throw new LGDPException(LGDPException.ExceptionType.RESOURCE_ALREADY_EXISTS, "Role with that name already exists");
        }

        Role new_role = new Role();

        BeanUtils.copyProperties(new_role, details);

        return this.saveRole(new_role);
    }

    @Override
    public RoleModelDetails update(RoleModelDetails details) {

        Optional<Role> roleOptional = this.roleRepository.findRoleByName(details.getName());

        if (!roleOptional.isPresent()) {
            throw new LGDPException(LGDPException.ExceptionType.RESOURCE_ALREADY_EXISTS, "A Role with that name already exists");
        }

        return saveRole(roleOptional.get());

    }

    @Override
    public void delete(Long id) {

        Optional<Role> role = this.roleRepository.findById(id);

        if (!role.isPresent())
        {
            throw new LGDPException(LGDPException.ExceptionType.RESOURCE_DOES_NOT_EXISTS, "Role does not exists");
        }

        this.roleRepository.deleteById(id);
    }

    /**
     * Save the instance
     *
     * @param role
     * @return
     */
    private RoleModelDetails saveRole(Role role)
    {
        role = this.roleRepository.save(role);

        return role.getRoleModelDetails();
    }
}
