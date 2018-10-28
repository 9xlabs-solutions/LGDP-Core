package com.ninexlabs.lgdp.usermodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@EnableConfigurationProperties
public class UserModuleApplication
{
	
	public static void main(String[] args)
	{
		SpringApplication.run(UserModuleApplication.class, args);
	}
}
