package com.ninexlabs.lgdp.usermodule.models;

import com.ninexlabs.lgdp.commons.models.BaseModel;
import com.ninexlabs.lgdp.commons.models.RoleModelDetails;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends BaseModel {

    private String name;

    private String description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<User> users = new HashSet<>();

//    private Set<Permission> permissions = new HashSet<>();

    public Role() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }

    /**
     * Get the shadow class instance
     *
     * @return
     */
    public RoleModelDetails getRoleModelDetails() {

        RoleModelDetails roleModelDetails = new RoleModelDetails();

        BeanUtils.copyProperties(this, roleModelDetails);

        return roleModelDetails;
    }
}
