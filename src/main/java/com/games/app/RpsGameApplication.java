package com.games.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RpsGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpsGameApplication.class, args);
	}
	public String getValue() {
		return "Hello Service";
	}

}