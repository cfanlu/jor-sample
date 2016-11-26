package com.jatools.jor.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import java.lang.invoke.MethodHandles;

@SpringBootApplication
@ComponentScan(basePackages = "com.jatools.jor.sample")
public class Application extends SpringBootServletInitializer {

	public static final Logger logger = LoggerFactory
			.getLogger(MethodHandles.lookup().lookupClass());

	public static void main(String[] args) {
		// -Dspring.profiles.active=dev
		SpringApplication.run(Application.class, args);
	}
}