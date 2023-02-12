package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Value("${hello.message: 반갑습니다.}")
	private String helloMessage;

	@GetMapping("/hello")
	public String getHello() {
		return helloMessage;
	}
}
