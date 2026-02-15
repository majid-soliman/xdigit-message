package com.java.xdigit_message2.ent;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "message")
@Data
@NoArgsConstructor
public class MessageEnt {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "session_id")
	private String sessionId;
	private String message;
	private Date creatingTime;
	
	public MessageEnt(String sessionId, String message, Date creatingTime) {
		this.sessionId = sessionId;
		this.message = message;
		this.creatingTime = creatingTime;
	}
	
	
	
}
