package com.keyin.DASfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class, SessionAutoConfiguration.class})
public class DasFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DasFinalApplication.class, args);
	}

}
