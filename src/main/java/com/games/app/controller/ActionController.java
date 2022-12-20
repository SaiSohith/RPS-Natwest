package com.games.app.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.games.app.ApiResponse;
import com.games.app.service.ActionService;

@RestController

@RequestMapping(path="action/")

public class ActionController {
	
	private final ActionService gameActionService;
	
	Logger logger=LoggerFactory.getLogger(ActionController.class);
	
	@Autowired
	public ActionController(ActionService gameActionService) {
		this.gameActionService=gameActionService;
		logger.trace("Initializing gameActionService");
	}
	
	@GetMapping(path="/{UserMove}")
	public ApiResponse game_state(@PathVariable("UserMove") String userMove){
		
		if(!userMove.equals("Scissor") && !userMove.equals("Rock") && !userMove.equals("Paper")) {
			logger.info("Invalid Input");
			return new ApiResponse(422,"Invalid Input");
		}
		
		
		String gamePlayResult=gameActionService.findResult(userMove);
		
		logger.info("Game Play Result  "+gamePlayResult);
		
		return new ApiResponse(200,gamePlayResult);
	}
	
	
}
