package com.project.david;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Log4j2TestApplication {
	private static final Logger logger=LogManager.getLogger(Log4j2TestApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(Log4j2TestApplication.class, args);
		logger.info("Application started successfully.");
		logger.error("This is an error message");
	}

}
