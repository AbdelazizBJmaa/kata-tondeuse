package com.kata.Tondeuse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.kata.Tondeuse.application.exception.FileFormatInvalidException;
import com.kata.Tondeuse.application.parse.PositionParse;
import com.kata.Tondeuse.domain.model.Direction;
import com.kata.Tondeuse.domain.model.Position;

class TestPositionLine {

	@Test
	void testPositionCorrect() throws FileFormatInvalidException {
		String line = "1 2 N";
		Position p = new PositionParse(line).parse();
		assertEquals(p.getX(), 1);
		assertEquals(p.getY(), 2);
		assertEquals(p.getDirection(), Direction.N);
	}
	
	@Test
	void testPositionInCorrect_position() throws FileFormatInvalidException {
		String line = "1 2 G";
		assertThrows(FileFormatInvalidException.class, ()->new PositionParse(line).parse());
	}
	
	@Test
	void testPositionInCorrect_format() throws FileFormatInvalidException {
		String line = "1 2";
		assertThrows(FileFormatInvalidException.class, ()->new PositionParse(line).parse());
	}

}
