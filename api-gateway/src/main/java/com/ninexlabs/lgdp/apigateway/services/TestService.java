package com.ninexlabs.lgdp.apigateway.services;

import com.ninexlabs.lgdp.commons.LGDPException;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    public String test() {
//        return "Welcome to LGDS";
        throw new LGDPException(LGDPException.ExceptionType.INVALID_DATA_EXCEPTION, "Test");
    }
}
