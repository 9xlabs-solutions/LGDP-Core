package com.ninexlabs.lgdp.usermodule.controllers.auth;

import com.ninexlabs.lgdp.commons.models.UserModelDetails;
import com.ninexlabs.lgdp.usermodule.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController
{

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Find a user by username
     *
     * @return UserModelDetails
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserModelDetails> findUserByEmailOrUsername(@RequestParam("username") String username)
    {
        UserModelDetails user = this.userService.findUserByUsername(username);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
