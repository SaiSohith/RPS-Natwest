package com.games.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;



@SpringBootApplication
public class RpsGameApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RpsGameApplication.class, args);
	}
	
	@CrossOrigin
	@GetMapping(path="/")
	public String getValue() {
		return "index.html";
	}

}
