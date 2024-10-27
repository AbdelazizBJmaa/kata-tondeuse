package com.kata.Tondeuse.application.parse;

import java.util.Objects;

public class InstructionParse extends AbstractLineParser<String> {

	public InstructionParse(String line) {
		super(line);
	}

	@Override
	protected boolean isValidLine() {
		return !Objects.isNull(line) && !line.isBlank() && line.matches("[D|G|A]+");
	}

	@Override
	protected String process() {
		// TODO Auto-generated method stub
		return line;
	}

}
