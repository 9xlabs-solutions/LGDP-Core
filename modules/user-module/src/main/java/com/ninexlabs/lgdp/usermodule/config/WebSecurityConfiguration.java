package com.ninexlabs.lgdp.usermodule.config;


import com.ninexlabs.lgdp.usermodule.services.UserService;
import com.ninexlabs.lgdp.usermodule.services.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter
{
	
	@Autowired
	private UserService userService;
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
	//	auth.userDetailsService()
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity
				.authorizeRequests()
				.antMatchers(VersionService.BASE_PATH + "*")
				.permitAll();
		
		httpSecurity.csrf().disable();
	}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

