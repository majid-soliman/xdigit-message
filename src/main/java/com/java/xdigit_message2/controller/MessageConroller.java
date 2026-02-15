package com.java.xdigit_message2.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.java.xdigit_message2.ent.MessageEnt;
import com.java.xdigit_message2.service.MessageService;

import jakarta.servlet.http.HttpSession;



@RestController 
public class MessageConroller {

	 @Autowired
     private MessageService service; 
	 
        @PostMapping("/saveMessage")
	    public String getHelloWordObject(@RequestBody Map<String, Object> reqMap) {
	    Map<String, Object> resMap = service.saveMessage(reqMap.get("sessionId").toString(),
	    reqMap.get("message").toString());
	    
	    System.out.println("Message saved: "+resMap);
	    
	    return "Mesasge created";
	    }
        
        @PostMapping("/getBySessionId")
        public List<MessageEnt> getMessagesBySessionId(@RequestBody Map<String, Object> reqMap){
        	return service.getBySessinId(reqMap);
        }
        
        @PostMapping("/getMessages")
        public Map<String,Object> getAllMessages(@RequestBody Map<String, Object> reqMap) {
        return Map.of("Messages",service.getAllMessages((Integer)reqMap.get("pageNumber"),
        	(Integer)reqMap.get("pageSize"),reqMap.get("sortBy").toString()));
        
   
        }
        
        @PostMapping("/deleteMessages")
        public String deleteMessages(@RequestBody Map<String, Object> reqMap) {
        return service.deleteMesasges((String)reqMap.get("sessionId")); 	
       }
	
}
