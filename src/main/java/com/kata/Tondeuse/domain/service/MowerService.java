package com.kata.Tondeuse.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kata.Tondeuse.domain.model.Lawn;
import com.kata.Tondeuse.domain.model.Position;

public class MowerService implements IMowerService {

	Logger logger = LoggerFactory.getLogger(MowerService.class);

	@Override
	public Position executeInstructions(Lawn lawn, Position startPosition, String instructions) {
		Position position = new Position(startPosition.getX(), startPosition.getY(), startPosition.getDirection());

		for (char c : instructions.toCharArray()) {
			switch (c) {
			case 'D' -> position.turnRight();
			case 'G' -> position.turnLeft();
			case 'A' -> {
				if (lawn.isValidPosition(position))
					position.move();
			}
			default -> throw new IllegalArgumentException(" Invalid Instruction "  + c);
			}
		}

		return position;
	}

}
