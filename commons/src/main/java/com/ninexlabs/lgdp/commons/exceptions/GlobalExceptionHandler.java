package com.ninexlabs.lgdp.commons.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler
{

	public final ResponseEntity handleException(Exception ex)
	{
		return null;
	}

}
