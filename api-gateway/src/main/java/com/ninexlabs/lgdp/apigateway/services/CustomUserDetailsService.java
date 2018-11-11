package com.ninexlabs.lgdp.apigateway.services;

import com.ninexlabs.lgdp.apigateway.security.UserPrincipal;
import com.ninexlabs.lgdp.apigateway.services.api.UserModuleService;
import com.ninexlabs.lgdp.commons.models.UserModelDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public class CustomUserDetailsService implements UserDetailsService
{

    @Autowired
    private UserModuleService userModuleService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModelDetails userModelDetails = this.userModuleService.getUserDetails(username);

        if (userModelDetails == null) {
            throw new UsernameNotFoundException("Account was not found on our system");
        }

        return UserPrincipal.create(userModelDetails);

    }

    // This method is used by JWTAuthenticationFilter
//    @Transactional
//    public UserDetails loadUserById(Long id) {
//        User user = this.userModuleService.findById(id).orElseThrow(
//                () -> new UsernameNotFoundException("User not found with id : " + id)
//        );
//
//        return UserPrincipal.create(user);
//    }
}
