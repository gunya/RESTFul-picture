package com.hepexta.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	PasswordEncoder encoder;

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/login").permitAll()
				.antMatchers("/admin").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and().formLogin().permitAll()
				.and().csrf().disable();
		;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password(encoder.encode("pass")).roles("USER");
	}
}
