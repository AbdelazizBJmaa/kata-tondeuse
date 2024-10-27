package com.kata.Tondeuse.application.parse;

import com.kata.Tondeuse.application.exception.FileFormatInvalidException;

public abstract class AbstractLineParser<T> {

	protected String line;

	protected AbstractLineParser(String line) {
		this.line = line;
	}

	protected abstract boolean isValidLine();

	protected abstract T process();

	public T parse() throws FileFormatInvalidException {
		if (!isValidLine()) {
			throw new FileFormatInvalidException(String.format("%s the format is invalid", line));
		}

		return process();
	}

}
