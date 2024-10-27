package com.kata.Tondeuse.Adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.kata.Tondeuse.application.writer.CustomWriterAggregate;
import com.kata.Tondeuse.domain.model.Direction;
import com.kata.Tondeuse.domain.model.Position;

class TestWriteAdapter {

	private final CustomWriterAggregate custom = new CustomWriterAggregate();
	
	@Test
	void test_write() {
		Position position = new Position(1,3,Direction.N);
		String expected = custom.aggregate(position);
		expected = expected.substring(0 , expected.length() - 1);
		assertEquals("position final :1 3 N", expected);
		
	}

}
