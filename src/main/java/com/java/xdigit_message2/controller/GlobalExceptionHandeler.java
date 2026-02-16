package com.java.xdigit_message2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.java.xdigit_message2.exception.NotFoundCustomException;

@ControllerAdvice
public class GlobalExceptionHandeler {

	
	@ExceptionHandler(value  = NotFoundCustomException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Object>exception(NotFoundCustomException e){
		return new ResponseEntity<>("Session not found ",HttpStatus.NOT_FOUND);
	}
	
}
