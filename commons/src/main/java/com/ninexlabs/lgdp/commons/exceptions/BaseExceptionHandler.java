package com.ninexlabs.lgdp.commons.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BaseExceptionHandler {

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Map<String, Object>> validationErrorHandler(ConstraintViolationException e) {
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, String> errors = new HashMap<String, String>();
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();

        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
        }

        response.put("error", errors);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
    }

}
