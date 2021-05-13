package com.spring.fleamarket.domain.chat.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.fleamarket.domain.account.service.AccountFindService;
import com.spring.fleamarket.domain.model.Account;
import com.spring.fleamarket.global.security.annotation.LoginedAccount;

@Controller
public class WebController {

	@Autowired
	AccountFindService serviceAF;
	
	@GetMapping("/chat")
	public String getPage(Principal principal, Model model, @LoginedAccount Account account ) {
		
		model.addAttribute("chatUser", serviceAF.selectAll());
		
		if(principal != null) {
			
			model.addAttribute("userId", account.getId());
			model.addAttribute("userName", account.getName());
			
		}
		
		return "chat";
	}

}
