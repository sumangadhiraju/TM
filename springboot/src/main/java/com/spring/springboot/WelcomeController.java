package com.spring.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.service.WelcomeService;

@RestController
public class WelcomeController {

	@Autowired
	private WelcomeService service;
	@RequestMapping("/welcome")
	public String welcome(){
		return service.retrieveWelcomeMessage();
	}
	
}

