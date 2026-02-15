package com.java.xdigit_message2.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.xdigit_message2.dao.MessageDAO;
import com.java.xdigit_message2.ent.MessageEnt;

@Service
public class MessageService {

	@Autowired
	private MessageDAO messageDAO;
	
	public Map<String, Object> saveMessage(String sessionId, String message) {
	return Map.of("message", messageDAO.saveMessage(
	new MessageEnt(sessionId, message, new Date())));
	}
	
	public List<MessageEnt> getBySessinId(Map<String, Object> reqMap){
		return messageDAO.getById(reqMap.get("sessionId").toString());
	}
	
	public List<MessageEnt> getAllMessages(
            Integer pageNo,
            Integer pageSize,
            String sortBy)
    {
   List<MessageEnt> list = messageDAO.getMessages(pageNo, pageSize, sortBy);
   System.out.println("Reslit size: "+list.size());

   return list;
   }
	
   public String deleteMesasges(String sessionId) {
	    return messageDAO.deleteMessages(sessionId);
   }
	
	
	
	
}
