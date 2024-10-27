package com.kata.Tondeuse.domain.model;

public enum Direction {
	N, E, S, W;

	public Direction turnRight() {
		return switch (this) {
		case N -> E;
		case W -> N;
		case S -> W;
		case E -> S;

		};
	}

	public Direction turnLeft() {
		return switch (this) {
		case N -> W;
		case E -> N;
		case S -> E;
		case W -> S;

		};
	}

}
