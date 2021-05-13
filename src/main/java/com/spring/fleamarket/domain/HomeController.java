package com.spring.fleamarket.domain;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class HomeController {
	
	/*
	 * 최초 페이지에 접속했을 때, CSRF 토큰을 발급한다.
	 */
	
	@GetMapping("/")
	public ResponseEntity<String> init(CsrfToken token) {
		log.info("token=" + token.getToken());
		return new ResponseEntity<>(token.getToken(), HttpStatus.OK);
	}
	
	/*
	@ResponseBody
	@GetMapping("/test")
	public ResponseEntity<String> test() {
		
		return new ResponseEntity<>("hello", HttpStatus.CREATED);
	}
	*/

}
