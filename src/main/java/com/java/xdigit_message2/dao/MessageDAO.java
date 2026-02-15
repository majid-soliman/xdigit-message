package com.java.xdigit_message2.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.java.xdigit_message2.ent.MessageEnt;
import com.java.xdigit_message2.repo.MessageRepo;
import com.java.xdigit_message2.repo.MessgaePagination;

@Component
public class MessageDAO {

	
	@Autowired
	private MessageRepo messageRepo;
	 
	@Autowired
	private  MessgaePagination messagePagination;
	
	public MessageEnt saveMessage(MessageEnt messageEnt) {
		return messageRepo.save(messageEnt);
	}
	
	public List<MessageEnt> getById(String sessionId){
	return messageRepo.findBySessionId(sessionId).get();	
	}
	
    public List<MessageEnt> getMessages(Integer pageNo, Integer pageSize, String sortBy)
	{
	  Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
            Page<MessageEnt> pagedResult = messagePagination.findAll(paging);
           if(pagedResult.hasContent()) {
	            return pagedResult.getContent();
	        } else {
	            return new ArrayList<MessageEnt>();
	        }
	}
    
    
    public String deleteMessages(String sessionId) {
    	Optional<List<MessageEnt>> ent = messageRepo.findBySessionId(sessionId);
    
    if(ent.isPresent()) {
    	messageRepo.deleteAll(ent.get());
    	System.out.println("Recived SessionidL "+sessionId);
    	return "Messages with SessionID "+sessionId+" Deleted!";
    }else {
    	return "Session not found!";
    }
    	
    }
  
	
	
	
	
	
}
