package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("production")
public class ProductionHelloController {
	@Value("${hello.message}")
	private String helloMessage;
	
	@Value("${hello.countries}")
	private List<String> countries;
	
	@Value("#{${hello.account}}")
	private Map<String, String> accountMap;

	@GetMapping("/hello")
	public String getHello() {
		return "[ProductionHelloController]" + helloMessage + " " + countries + " " + accountMap.get("name") + " " + accountMap.get("password");
	}

}
