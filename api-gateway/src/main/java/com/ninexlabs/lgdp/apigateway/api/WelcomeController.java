package com.ninexlabs.lgdp.apigateway.api;

import com.ninexlabs.lgdp.apigateway.Test;
import com.ninexlabs.lgdp.apigateway.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/welcome")
public class
WelcomeController {
    private TestService testService;

    @Autowired
    public WelcomeController(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String welcome() {
        return testService.test();
    }

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    public Test versionCheck() {
        return new Test();
    }
}
