package com.ninexlabs.lgdp.usermodule.models;


import com.ninexlabs.lgdp.commons.models.BaseModel;
import com.ninexlabs.lgdp.commons.models.RoleModelDetails;
import com.ninexlabs.lgdp.commons.models.UserModelDetails;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User extends BaseModel {

    @NotNull(message = "Name cannot be empty")
    @Size(min = 3, max = 10)
    private String name;

    @Column(unique = true)
    private String username;

    private String remeber_token;

    @Email
    @NotNull
    private String email;

    private String contact;

    private String address;

    private String password;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> roles;

//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
//    private Set<Permission> permissions = new HashSet<>();

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public String getUsername() {
        return username;
    }

    public Set<RoleModelDetails> getRoles() {

        Set<RoleModelDetails> details = new HashSet<>();

        for (Role role : roles) {
            details.add(role.getRoleModelDetails());
        }

        return details;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

//    public Set<Permission> getPermissions() {
//        return permissions;
//    }
//
//    public void setPermissions(Set<Permission> permissions) {
//        this.permissions = permissions;
//    }

    /**
     * Get the user roles from the user models
     *
     * @return
     */
    public UserModelDetails getUserModelDetails() {

        // create a new user model
        UserModelDetails userModelDetails = new UserModelDetails();

        // use the bean utils to copy to the class props
        BeanUtils.copyProperties(this, userModelDetails);

        return userModelDetails;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
