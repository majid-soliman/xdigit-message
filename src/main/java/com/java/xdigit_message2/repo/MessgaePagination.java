package com.java.xdigit_message2.repo;

import java.util.List;

import org.springframework.boot.data.autoconfigure.web.DataWebProperties.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.java.xdigit_message2.ent.MessageEnt;

public interface MessgaePagination extends PagingAndSortingRepository<MessageEnt, Integer>{

	@Query("SELECT m FROM MessageEnt m WHERE m.sessionId = :sessionid")
	List<MessageEnt> findBySessionId(@Param("sessionid") String sessionId, Pageable pageable);
	
}
