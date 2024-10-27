package com.kata.Tondeuse.Adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.kata.Tondeuse.application.processor.MowerProcessingAdapter;
import com.kata.Tondeuse.domain.model.Direction;
import com.kata.Tondeuse.domain.model.Lawn;
import com.kata.Tondeuse.domain.model.Position;
import com.kata.Tondeuse.domain.service.MowerService;

class ProcessingAdapterTest {

	@Mock
	private MowerService mowerService;
	
	@InjectMocks
	private MowerProcessingAdapter processingAdapter;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testprocessAdapter() {
		Lawn lawn = new Lawn(5,5);
		Position startPosition = new Position(1,2,Direction.N);
		String instruction = "GAGAGAGAA";
		Position expectedPosition = new Position(1, 3, Direction.N);
		
		when(mowerService.executeInstructions(lawn, startPosition, instruction)).thenReturn(expectedPosition);
		
		Position finalPosition = processingAdapter.process(lawn, startPosition, instruction);

        verify(mowerService, times(1)).executeInstructions(lawn, startPosition, instruction);
        assertEquals(expectedPosition, finalPosition);
		
	}

}
