package com.spring.fleamarket.domain.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.fleamarket.domain.account.service.AccountFindService;
import com.spring.fleamarket.domain.chat.model.MessageModel;
import com.spring.fleamarket.domain.chat.service.MessageSaveService;
import com.spring.fleamarket.domain.model.Account;
import com.spring.fleamarket.global.security.annotation.LoginedAccount;

@RestController
@CrossOrigin
public class UsersController {
	
	@Autowired
	MessageSaveService service;
	
	@Autowired
	AccountFindService serviceAF;
	
	@GetMapping("/recallChat/{userId}")
	public List<MessageModel> recall(@PathVariable int userId, MessageModel msgModel, @LoginedAccount Account account) {
		
		
		//int sender = account.getId();
		
		int sender = 1;
		
		int receiver = userId;
		
		msgModel.setSenderId(sender);
		
		msgModel.setReceiverId(receiver);
			
		return service.recallChat(msgModel);
	}
	
	
}
