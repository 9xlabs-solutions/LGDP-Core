package com.ninexlabs.lgdp.usermodule.services.interfaces;

import com.ninexlabs.lgdp.commons.models.RoleModelDetails;

import java.util.List;

public interface IRoleService {

    List<RoleModelDetails> index();

    RoleModelDetails show(Long id);

    RoleModelDetails store(RoleModelDetails role);

    RoleModelDetails update(RoleModelDetails role);

    void delete(Long id);
}
