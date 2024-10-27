package com.kata.Tondeuse.application.model;

import com.kata.Tondeuse.application.exception.InitialPositionException;
import com.kata.Tondeuse.domain.model.Lawn;
import com.kata.Tondeuse.domain.model.Position;

public class MowerInstruction {
   
	private Lawn lawn;
	private Position position;
	private String instruction;
	
	public MowerInstruction(Lawn lawn, Position position, String instruction) throws InitialPositionException {
		
		if(!lawn.isValidPosition(position)) {
			throw new InitialPositionException("Initial Position is not invalid");
		}
		
		this.lawn = lawn;
		this.position = position;
		this.instruction = instruction;
	}

	public Lawn getLawn() {
		return lawn;
	}

	public void setLawn(Lawn lawn) {
		this.lawn = lawn;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}


	
	
	
	
}
