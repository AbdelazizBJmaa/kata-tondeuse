package com.kata.Tondeuse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.kata.Tondeuse.application.exception.FileFormatInvalidException;
import com.kata.Tondeuse.application.parse.LawnParser;
import com.kata.Tondeuse.domain.model.Lawn;

class TestParseLine {

	@Test
	public void testLawnLineCorrect() throws FileFormatInvalidException {
		String line = "5 5";
		Lawn law = new LawnParser(line).parse();
		assertEquals(law.getWidth(), 5);
		assertEquals(law.getHeight(), 5);
	}

	@Test
	public void testLawnLine_with_negatif_number() {
		String line = "5 -2";
		assertThrows(FileFormatInvalidException.class, () -> new LawnParser(line).parse());
	}

	@Test
	public void testLawnLine_with_one_value() {
		String line = "5";
		assertThrows(FileFormatInvalidException.class, () -> new LawnParser(line).parse());
	}

}
