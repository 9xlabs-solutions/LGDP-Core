package com.ninexlabs.lgdp.apigateway.security;

import  org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthenticationEntrypoint implements AuthenticationEntryPoint
{
	
	private static final Logger logger = LoggerFactory.getLogger(JWTAuthenticationEntrypoint.class);
	
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException
	{
	
		logger.debug("Responding with unauthorized error. Message - {}", authException.getMessage());
		
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Sorry, You're not authorized to access this resource.");
		
	}
}
