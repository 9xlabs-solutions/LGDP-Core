package com.ninexlabs.lgdp.apigateway.services;

import com.ninexlabs.lgdp.apigateway.services.api.UserModuleService;
import com.ninexlabs.lgdp.commons.models.UserModelDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class CustomUserDetailsService implements UserDetailsService
{

    @Autowired
    private UserModuleService userModuleService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModelDetails userModelDetails = this.userModuleService.getUserDetails(username);

        return null;

    }
}
