package com.kata.Tondeuse.application.parse;

import com.kata.Tondeuse.domain.model.Direction;
import com.kata.Tondeuse.domain.model.Position;

public class PositionParse extends AbstractLineParser<Position> {

	public PositionParse(String line) {
		super(line);
	}

	@Override
	protected boolean isValidLine() {
		return !line.isBlank() && line.matches("^[0-9] [0-9] (N|S|W|E)$");
	}

	@Override
	protected Position process() {
		String[] pos = line.split(" ");
		return new Position(Integer.valueOf(pos[0]), Integer.valueOf(pos[1]), Direction.valueOf(pos[2]));
	}
	
	
	

}
