package com.ninexlabs.lgdp.apigateway.security;

import com.ninexlabs.lgdp.apigateway.services.api.AuthenticationService;
import com.ninexlabs.lgdp.commons.models.UserModelDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserService implements UserDetailsService {

    // user module service
    private AuthenticationService authenticationService;

    @Autowired
    public CustomUserService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    /**
     * Get the user from username
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModelDetails userModelDetails = this.authenticationService.getUserDetailsByUsernameForLogin(username);

        return UserPrincipal.create(userModelDetails);
    }

    /**
     * Since JWT only decodes and get the ID, this method fetches user details from ID
     *
     * @param id
     * @return
     * @throws UsernameNotFoundException
     */
    public UserDetails loadUserById(Long id) throws UsernameNotFoundException {
        return UserPrincipal.create(this.authenticationService.loadUserById(id));
    }
}
