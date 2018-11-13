package com.ninexlabs.lgdp.apigateway.api;

import com.ninexlabs.lgdp.apigateway.requests.auth.LoginRequest;
import com.ninexlabs.lgdp.apigateway.requests.auth.SignupRequest;
import com.ninexlabs.lgdp.apigateway.responses.auth.JWTAuthenticationResponse;
import com.ninexlabs.lgdp.apigateway.security.JWTTokenProvider;
import com.ninexlabs.lgdp.apigateway.services.api.UserModuleService;
import com.ninexlabs.lgdp.commons.LGDPException;
import com.ninexlabs.lgdp.commons.models.UserModelDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/auth")
public class AuthenticationController {

    // authentication manager
    private final AuthenticationManager authenticationManager;

    // JWT token provider
    private final JWTTokenProvider jwtTokenProvider;

    // User Model Service
    private UserModuleService userModuleService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JWTTokenProvider jwtTokenProvider,
                                    UserModuleService userModuleService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userModuleService = userModuleService;
    }

    /**
     * Authenticate user into the application
     *
     * @param loginRequest Login Request
     * @return JWT Token
     */
    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        // Authenticate user from JWTAuthenticationFilter
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        // set the context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // generate a JWT Token
        String jwt = jwtTokenProvider.generateToken(authentication);

        // return the response
        return ResponseEntity.ok(new JWTAuthenticationResponse(jwt));
    }

    /**
     * Create a new user in the system
     *
     * @param request Singup request
     * @return Details of the created user
     */
    @RequestMapping(method = RequestMethod.POST, path = "/signup")
    public ResponseEntity<UserModelDetails> create(@Valid @RequestBody SignupRequest request) {

        // create the user using the user module through the user module service ( internal api )
        UserModelDetails userModelDetails = this.userModuleService.create(request);

        // check for the returned object
        if (userModelDetails == null) {
            throw new LGDPException(LGDPException.ExceptionType.INVALID_DATA_EXCEPTION, "Failed to register user.");
        }

        // return the details of the newly created user.
        return new ResponseEntity<>(userModelDetails, HttpStatus.CREATED);
    }

}
