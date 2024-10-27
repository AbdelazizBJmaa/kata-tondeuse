package com.kata.Tondeuse.application.ports;

import com.kata.Tondeuse.domain.model.Lawn;
import com.kata.Tondeuse.domain.model.Position;

public interface MowerProcessorPort {
   Position process (Lawn lawn , Position startPosition, String instruction);
}
