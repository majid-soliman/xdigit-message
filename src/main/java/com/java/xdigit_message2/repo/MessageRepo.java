package com.java.xdigit_message2.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.java.xdigit_message2.ent.MessageEnt;

public interface MessageRepo extends JpaRepository<MessageEnt, Integer> {

	@Query("SELECT m FROM MessageEnt m WHERE m.sessionId =:sessionId")
	Optional<List<MessageEnt>> findBySessionId(@Param("sessionId") String sessionId);
	
	
	
}
