package com.ninexlabs.lgdp.commons.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RoleModelDetails extends BaseModelDetails {

    private String name;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
