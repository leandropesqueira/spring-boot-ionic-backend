package com.leandrolopes.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.leandrolopes.cursomc.services.DBService;
import com.leandrolopes.cursomc.services.EmailService;
import com.leandrolopes.cursomc.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {		
		dbService.instantiateTestDatabase();		
		return true;
	}
	
	@Bean
	public EmailService emailservice() {
		return new MockEmailService();
	}
	
}
