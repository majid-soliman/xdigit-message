package com.java.xdigit_message2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundCustomException extends RuntimeException {

	private static final long serialVersionUID = 7428051251365675318L;

	   public NotFoundCustomException(String message) {
	      super(message);
	   }
	
}
