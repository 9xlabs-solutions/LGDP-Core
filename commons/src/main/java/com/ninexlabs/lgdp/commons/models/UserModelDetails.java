package com.ninexlabs.lgdp.commons.models;

import java.util.Date;
import java.util.Set;

public class UserModelDetails extends BaseModelDetails {

    private String name;

    private String email;

    private String address;

    private String contact;

    private String username;

    private String password;

    private Date dob;

    private boolean isActive;

    private Set<RoleModelDetails> roles;

    private Set<PermissionModelDetails> permission;

    public UserModelDetails() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Set<RoleModelDetails> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleModelDetails> roles) {
        this.roles = roles;
    }

    public Set<PermissionModelDetails> getPermission() {
        return permission;
    }

    public void setPermission(Set<PermissionModelDetails> permission) {
        this.permission = permission;
    }

    //    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }
}
