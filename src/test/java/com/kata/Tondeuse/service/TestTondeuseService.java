package com.kata.Tondeuse.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kata.Tondeuse.domain.model.Direction;
import com.kata.Tondeuse.domain.model.Lawn;
import com.kata.Tondeuse.domain.model.Position;
import com.kata.Tondeuse.domain.service.MowerService;

class TestTondeuseService {

	
	private MowerService mowerService;
	private Lawn lawn;
	
	
	@BeforeEach
	void setUp() {
		mowerService = new MowerService();
		lawn = new Lawn(5,5);
	}
	
	@Test
	void testMowerInBound() {
		Position startPosition = new Position(1, 2, Direction.N);
		String instruction = "GAGAGAGAA";
		
		Position finalPosition = mowerService.executeInstructions(lawn, startPosition, instruction);
		
		assertEquals(1, finalPosition.getX());
		assertEquals(3, finalPosition.getY());
		assertEquals(Direction.N,finalPosition.getDirection());
	}
	
	@Test
	void testMownerOutBound() {
		Position startPosition = new Position(5, 5, Direction.N);
		String instruction = "A";
		
		Position finalPosition = mowerService.executeInstructions(lawn, startPosition, instruction);
		
		assertEquals(5, finalPosition.getX());
		assertEquals(5, finalPosition.getY());
		assertEquals(Direction.N,finalPosition.getDirection());
	}
	
	@Test
	void testMownerTurnRight() {
		Position startPosition = new Position(1, 2, Direction.S);
		String instruction = "D";
		Position finalPosition = mowerService.executeInstructions(lawn, startPosition, instruction);
		
		assertEquals(finalPosition.getDirection(), Direction.W);
	}
	
	@Test
	void testMownerTurnLeft() {
		Position startPosition = new Position(1, 2, Direction.S);
		String instruction = "G";
		Position finalPosition = mowerService.executeInstructions(lawn, startPosition, instruction);
		
		assertEquals(finalPosition.getDirection(), Direction.E);
	}


}
