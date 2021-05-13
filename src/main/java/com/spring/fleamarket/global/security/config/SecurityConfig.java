package com.spring.fleamarket.global.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.spring.fleamarket.global.security.filter.RestAuthenticationFilter;
import com.spring.fleamarket.global.security.handler.RestAuthenticationFailureHandler;
import com.spring.fleamarket.global.security.handler.RestAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService service;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(passwordEncoder());
		super.configure(auth);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/login").permitAll()
//				.anyRequest().authenticated()
				.anyRequest().permitAll()
			.and()
			.formLogin().disable();
		http.addFilterAt(restAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public RestAuthenticationFilter restAuthenticationFilter() throws Exception {
		RestAuthenticationFilter filter = new RestAuthenticationFilter(new AntPathRequestMatcher("/login", "POST"));
		filter.setAuthenticationManager(this.authenticationManager());
		filter.setAuthenticationSuccessHandler(new RestAuthenticationSuccessHandler());
		filter.setAuthenticationFailureHandler(new RestAuthenticationFailureHandler());
		return filter;
	}

	
}
