package com.ninexlabs.lgdp.apigateway.services.api;

import com.ninexlabs.lgdp.apigateway.requests.auth.LoginRequest;
import com.ninexlabs.lgdp.apigateway.requests.auth.SignupRequest;
import com.ninexlabs.lgdp.commons.models.UserModelDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserModuleService {

    private Logger logger = LoggerFactory.getLogger(UserModuleService.class);

    // Rest Template for inter modular communications
    private RestTemplate restTemplate = new RestTemplate();

    @Value("${modules.user-module}")
    private String URL;

    public UserModelDetails getUserDetails(String username) {

        String loginURL = URL + "/api/v1/users/login/";

        LoginRequest loginRequest = new LoginRequest();

        loginRequest.setUsername(username);

        return this.restTemplate.postForObject(loginURL, loginRequest, UserModelDetails.class);

    }

    /**
     * Create a user principal object
     *
     * @param userModelDetails
     * @return
     */
    public UserModelDetails create(SignupRequest userModelDetails)
    {

        String registerURL = URL + "/api/v1/users/";

        UserModelDetails details = new UserModelDetails();

        BeanUtils.copyProperties(userModelDetails, details);

        return this.restTemplate.postForObject(registerURL, details, UserModelDetails.class);

    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserModelDetails loadUserById(Long id) {

        String userInfoURL = URL + "/api/v1/users/" + id;

        return this.restTemplate.getForObject(userInfoURL, UserModelDetails.class);
    }

    public List<UserModelDetails> index() {

        // build the URL
        String userInfoURL = URL + "/api/v1/users/";

        // get the response from user module
        ResponseEntity<List<UserModelDetails>> response = this.restTemplate.exchange(
                userInfoURL, // URL to make the request
                HttpMethod.GET, // Request type
                null,
                new ParameterizedTypeReference<List<UserModelDetails>>() {
                });

        // return the response back to user
        return response.getBody();

    }

}
