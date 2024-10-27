package com.kata.Tondeuse.application.ports;

import com.kata.Tondeuse.domain.model.Position;

public interface ResultWriterPort {
   String write(Position finalPosition);
}
