package com.ninexlabs.lgdp.apigateway.api;

import com.ninexlabs.lgdp.apigateway.annotations.CurrentUser;
import com.ninexlabs.lgdp.apigateway.security.UserPrincipal;
import com.ninexlabs.lgdp.apigateway.services.api.UserModuleService;
import com.ninexlabs.lgdp.commons.models.UserModelDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserModuleEndpoint {

    // user module service
    private UserModuleService userModuleService;

    @Autowired
    public UserModuleEndpoint(UserModuleService userModuleService) {
        this.userModuleService = userModuleService;
    }

    /**
     * Get all users in the system.
     *
     * @return list of users in the system
     */
    @RequestMapping(method = RequestMethod.GET, path = "/")
    @PreAuthorize("hasAnyRole('USER')")
    public List<UserModelDetails> index() {
        return userModuleService.index();
    }

    /**
     * Get the logged in user details.
     *
     * @param currentUser
     * @return Details of the current user
     */
    @RequestMapping(method = RequestMethod.GET, path = "/me")
    public UserPrincipal getCurrentLoggedInUserDetails(@CurrentUser UserPrincipal currentUser) {
        return currentUser;
    }

}
