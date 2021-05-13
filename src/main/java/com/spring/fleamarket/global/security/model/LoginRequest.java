package com.spring.fleamarket.global.security.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LoginRequest {

	private String username;
	private String password;

	@Builder
	public LoginRequest() {}

}
