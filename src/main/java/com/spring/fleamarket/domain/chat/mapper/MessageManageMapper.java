package com.spring.fleamarket.domain.chat.mapper;

import java.util.Date;
import java.util.List;

import com.spring.fleamarket.domain.chat.model.MessageModel;
import com.spring.fleamarket.domain.chat.model.UserListDTO;

public interface MessageManageMapper {

	public void saveMessage(MessageModel msgModel);
	
	public List<MessageModel> recallChat(MessageModel msgModel);
	
	public Date checkTime(int messageNo);
	
	public List<UserListDTO> bringUserList(int userId);

}