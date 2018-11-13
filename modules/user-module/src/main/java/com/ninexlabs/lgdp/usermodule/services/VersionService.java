package com.ninexlabs.lgdp.usermodule.services;

import com.ninexlabs.lgdp.usermodule.Version;
import org.springframework.stereotype.Component;

@Component
public class VersionService {

    /**
     * Module API base path
     */
    public static final String BASE_PATH = "/api/v1/";

    public static final String BASE_USER_PATH = "/api/v1/users/";

    public static final String BASE_ROLE_PATH = "/api/v1/roles/";

    /**
     * Get the version of the module
     *
     * @return Version of the module
     */
    public Version getVersion() {
        return new Version();
    }
}
