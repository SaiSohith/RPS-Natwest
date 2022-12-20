package com.games.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.games.app.controller.ActionController;

@Service
public class ActionService {
	
	Logger logger=LoggerFactory.getLogger(ActionService.class);
	
	public String generateRandomMove() {
		int min_range=1;
		int max_range=3;
		
		int range=max_range-min_range+1;
		
		int random_value=(int)(Math.random()*range)+min_range;
		
		logger.trace("Generated random value  "+random_value);
		
		if(random_value==1) {
			return "Rock";
		}
		if(random_value==2) {
			return "Paper";
		}
		if(random_value==3) {
			return "Scissor";
		}
		return "";
	}
	
	
	public String findResult(String UserMove) {
		String randomMove=generateRandomMove();
		
		logger.trace("Generated random Move  "+randomMove);
		
		if(UserMove.equals(randomMove)) {
			return "It is a tie";
		}
		else if( (UserMove.equals("Rock") && randomMove.equals("Scissor"))
				||(UserMove.equals("Scissor") && randomMove.equals("Paper"))
				|| (UserMove.equals("Paper") && randomMove.equals("Rock"))) {
			return "Player wins";
		}
		else {
			return "Computer wins";
		}
	}
}
