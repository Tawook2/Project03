package com.spring.fleamarket.global.security.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.fleamarket.global.security.model.LoginRequest;

public class RestAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	public RestAuthenticationFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
		super(requiresAuthenticationRequestMatcher);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException(request.getMethod() + " is not supported");
		}

		ObjectMapper objectMapper = new ObjectMapper();
		LoginRequest loginRequest = objectMapper.readValue(request.getReader(), LoginRequest.class);
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());

		return getAuthenticationManager().authenticate(authRequest);

	}

}