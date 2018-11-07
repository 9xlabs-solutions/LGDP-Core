package com.ninexlabs.lgdp.apigateway.services.api;

import com.ninexlabs.lgdp.commons.models.UserModelDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserModuleService
{

    private Environment environment;

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public UserModuleService(Environment environment) {
        this.environment = environment;
    }

    public UserModelDetails getUserDetails(String username)
    {

        String URL = this.environment.getProperty("modules.user-module");

        Map<String, String> params = new HashMap<>();

        params.put("username", username);

       return this.restTemplate.getForObject(URL, UserModelDetails.class, params);

    }

}
