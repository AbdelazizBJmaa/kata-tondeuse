package com.kata.Tondeuse.application.parse;

import com.kata.Tondeuse.domain.model.Lawn;

public class LawnParser extends AbstractLineParser<Lawn>{

	public LawnParser(String line) {
		super(line);
	}

	public boolean isValidLine() {
		return !line.isBlank() && line.matches("^[0-9] [0-9]$");
	}

	@Override
	protected Lawn process() {
		String[] pos = line.split(" ");
		return new Lawn(Integer.valueOf(pos[0]), Integer.valueOf(pos[1]));
	}
	
	
	
}
