package com.kata.Tondeuse.domain.service;

import com.kata.Tondeuse.domain.model.Lawn;
import com.kata.Tondeuse.domain.model.Position;

public interface IMowerService {
	 Position executeInstructions(Lawn lawn, Position startPosition, String instructions);
}
