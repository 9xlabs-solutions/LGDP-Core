package com.ninexlabs.lgdp.apigateway.api;

import com.ninexlabs.lgdp.apigateway.annotations.CurrentUser;
import com.ninexlabs.lgdp.apigateway.security.UserPrincipal;
import com.ninexlabs.lgdp.apigateway.services.api.AuthenticationService;
import com.ninexlabs.lgdp.commons.models.UserModelDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class AuthenticationEndpoint {

    // user module service
    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationEndpoint(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
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
