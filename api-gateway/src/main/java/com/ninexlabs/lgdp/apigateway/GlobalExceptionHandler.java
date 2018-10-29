package com.ninexlabs.lgdp.apigateway;

import com.ninexlabs.lgdp.commons.LGDPException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * by: Pasan Buddhika Weerathunga
 * Email: me@pasanlive.com
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = LGDPException.class)
    public ResponseEntity<Void> defaultErrorHandler(HttpServletRequest request, LGDPException ex) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        switch (ex.getExceptionType()) {
            case ALREADY_EXIST_EXCEPTION:
                httpStatus = HttpStatus.NOT_ACCEPTABLE;
                break;
            case INVALID_DATA_EXCEPTION:
                httpStatus = HttpStatus.BAD_REQUEST;
                break;
            case NOT_AUTHORIZED_EXCEPTION:
                httpStatus = HttpStatus.UNAUTHORIZED;
                break;
            case WRONG_VERIFICATION_CODE:
                httpStatus = HttpStatus.BAD_REQUEST;
                break;
            case ACCOUNT_NOT_VERIFIED:
                httpStatus = HttpStatus.PRECONDITION_FAILED;
                break;
            default:
                httpStatus = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(httpStatus).header("error-description", ex.getMessage()).body(null);
    }
}
