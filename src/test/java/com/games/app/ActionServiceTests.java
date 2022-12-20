package com.games.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.games.app.service.ActionService;

@SpringBootTest
public class ActionServiceTests {
	
	@Autowired
	private ActionService randomTest;
	
//	public ActionServiceTests() {
//		
//	}
	
	//Testing For the Random Value Range
	@Test
	void randomMoveTest() {
		int generated_value=randomTest.randomValueGenerator(1,3);
		int checkValue=0;
		if(generated_value>0 && generated_value<4) {
			checkValue=1;
		}
		assertEquals(1,checkValue);
	}
	
	
	
	//Testing For the Appropriate Response
	@Test
	void gameResultTest() {
		String res=randomTest.findResult("Rock");
		boolean check=false;
		if(res.equals("It is a tie") ||res.equals("Computer wins")||res.equals("Player wins") ) {
			check=true;
		}
		assertEquals(true,check);
	}
	
	
	
	
}
