package com.kata.Tondeuse.domain.model;

public class Position {
    private int x;
    private int y;
    private Direction direction;
	
    public Position(int x, int y, Direction direction) {
	
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void turnRight() {
		
		direction = direction.turnRight();
	}

	public void turnLeft() {
		direction =  direction.turnLeft();
	}

	public void move() {
		switch(direction) {
		case N -> y++;
		case S -> y--;
		case E -> x++;
		case W -> x--;
		}
		
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append(x).append(" ").append(y).append(" ").append(direction);
		return b.toString();
	}
    
    
    
}
