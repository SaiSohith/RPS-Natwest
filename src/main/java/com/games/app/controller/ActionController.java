package com.games.app.controller;

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
	
	@Autowired
	public ActionController(ActionService gameActionService) {
		this.gameActionService=gameActionService;
	}
	
	@GetMapping(path="/{UserMove}")
	public ApiResponse game_state(@PathVariable("UserMove") String UserMove){
		
		if(!UserMove.equals("Scissor") && !UserMove.equals("Rock") && !UserMove.equals("Paper")) {
			return new ApiResponse(422,"Invalid Input");
		}
		
		String gamePlayResult=gameActionService.findResult(UserMove);
		
		return new ApiResponse(200,gamePlayResult);
	}
	
	
}
