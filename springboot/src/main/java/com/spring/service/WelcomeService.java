package com.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WelcomeService {
	@Value("${welcome.message}")
	private String welcome;
	public String retrieveWelcomeMessage(){
		return welcome + "Good Morning updated";
	}
}
