package com.helloworld.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@RequestMapping("/Hello")
public class HelloController {

	@GetMapping
	public String hello() {
		
		return "Hello World";
	}
	
}
