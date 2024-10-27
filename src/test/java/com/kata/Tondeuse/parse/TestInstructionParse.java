package com.kata.Tondeuse.parse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.kata.Tondeuse.application.exception.FileFormatInvalidException;
import com.kata.Tondeuse.application.parse.InstructionParse;

class TestInstructionParse {

	@Test
	public void testInstructionCorrect() throws FileFormatInvalidException {
		String line="ADDAG";
		String res = new InstructionParse(line).parse();
		assertEquals(line,res);
	}
	
	@Test
	public void testInstructionInCorrect() throws FileFormatInvalidException {
		String line="ADDAGQ";
		assertThrows(FileFormatInvalidException.class, ()->new InstructionParse(line).parse());
	}


}
