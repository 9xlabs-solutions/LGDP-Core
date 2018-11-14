package com.ninexlabs.lgdp.usermodule.controllers.auth;

import com.ninexlabs.lgdp.commons.models.UserModelDetails;
import com.ninexlabs.lgdp.usermodule.services.UserService;
import com.ninexlabs.lgdp.usermodule.services.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = VersionService.BASE_USER_PATH)
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Find a user by username
     *
     * @return UserModelDetails
     */
    @RequestMapping(method = RequestMethod.POST, value = "login")
    public ResponseEntity<UserModelDetails> findUserByUsername(@RequestBody UserModelDetails username) {
        UserModelDetails user = this.userService.findUserByUsername(username.getUsername());

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
