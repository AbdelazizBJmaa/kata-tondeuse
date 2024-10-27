package com.kata.Tondeuse.domain.model;

public class Lawn {
	
	private int width;
	private int height;
	
	public Lawn(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("Lawn [width=");
		builder.append(width);
		builder.append(", height=");
		builder.append(height);
		builder.append("]");
		return builder.toString();
	}

	public boolean isValidPosition(Position position) {
		 return position.getX() >= 0 && position.getX() < width &&
	               position.getY() >= 0 && position.getY() < height;
	}
	
	

	
	
}
