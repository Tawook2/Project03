package com.spring.fleamarket.global.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class RestAuthenticationFailureHandler implements AuthenticationFailureHandler {@Override

	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		log.warn("LOGIN FAIL");
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
	}

}
