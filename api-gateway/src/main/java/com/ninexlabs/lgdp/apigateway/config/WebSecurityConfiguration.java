package com.ninexlabs.lgdp.apigateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter
{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
				.cors()
					.and()
				.csrf()
					.disable()
				.exceptionHandling()
					//.authenticationEntryPoint()
					.and()
				.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
					.and()
				.authorizeRequests()
				.antMatchers("/",
						"/favicon.ico",
						"/**/*.png",
						"/**/*.gif",
						"/**/*.svg",
						"/**/*.jpg",
						"/**/*.html",
						"/**/*.css",
						"/**/*.js")
					.permitAll()
					.and();
	}
}
