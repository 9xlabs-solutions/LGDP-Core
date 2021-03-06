package com.ninexlabs.lgdp.commons.models;

import java.util.Date;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseModelDetails {

    private long id;

    private Date created_at, updated_at;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
