package com.java.xdigit_message2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class XdigitMessage2Application {

	public static void main(String[] args) {
		SpringApplication.run(XdigitMessage2Application.class, args);
	}

}
