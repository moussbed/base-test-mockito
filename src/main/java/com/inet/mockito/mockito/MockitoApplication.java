package com.inet.mockito.mockito;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MockitoApplication {

	final static Logger logger = LoggerFactory.getLogger(MockitoApplication.class);
	public static void main(String[] args) {

		for(String arg:args) {
			logger.info("Bedril " +arg);
		}

		SpringApplication.run(MockitoApplication.class, args);
	}

}

