package com.ninexlabs.lgdp.usermodule.models;

import com.ninexlabs.lgdp.commons.models.BaseModel;
import com.ninexlabs.lgdp.commons.models.Permission;
import com.ninexlabs.lgdp.commons.models.Role;
import com.ninexlabs.lgdp.commons.models.UserModelDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity(name = "users")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "username"))
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

    private boolean isActive;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    @ElementCollection(targetClass = Role.class)
    private Collection<Role> roles;


    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Permission.class)
    @JoinTable(name = "user_permissions",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
    @ElementCollection(targetClass = Permission.class)
    private Collection<Permission> permissions;

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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Collection<Permission> getPermissions() {
        return permissions;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPermissions(Collection<Permission> permissions) {
        this.permissions = permissions;
    }

    public UserModelDetails getUserModelDetails() {
        UserModelDetails userModelDetails = new UserModelDetails();

        userModelDetails.setId(this.getId());
        userModelDetails.setUsername(this.getUsername());
        userModelDetails.setName(this.getName());
        userModelDetails.setEmail(this.getEmail());
        userModelDetails.setAddress(this.getAddress());
        userModelDetails.setCreated_at(this.getCreated_at());
        userModelDetails.setUpdated_at(this.getUpdated_at());

        return userModelDetails;
    }
}
