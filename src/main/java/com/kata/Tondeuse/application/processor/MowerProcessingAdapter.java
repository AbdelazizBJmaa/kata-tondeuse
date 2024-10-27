package com.kata.Tondeuse.application.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.kata.Tondeuse.application.ports.MowerProcessorPort;
import com.kata.Tondeuse.domain.model.Lawn;
import com.kata.Tondeuse.domain.model.Position;
import com.kata.Tondeuse.domain.service.IMowerService;
import com.kata.Tondeuse.domain.service.MowerService;

public class MowerProcessingAdapter implements MowerProcessorPort, ItemProcessor<Object, Position> {

	Logger logger = LoggerFactory.getLogger(MowerProcessingAdapter.class);

	private IMowerService mowerService;
	private Lawn lawn;
	private Position startPosition;

	public MowerProcessingAdapter() {
		mowerService = new MowerService();
	}

	@Override
	public Position process(Lawn lawn, Position startPosition, String instruction) {
		return mowerService.executeInstructions(lawn, startPosition, instruction);
	}

	@Override
	public Position process(Object item) throws Exception {
		switch (item) {
		case Lawn l -> {
			this.lawn = l;
			return null;
		}
		case Position p -> {
			this.startPosition = p;
			return null;
		}
		case String instruction -> {
			return process(this.lawn, this.startPosition, instruction);
		}
		default -> throw new IllegalArgumentException("Unexpected value: " + item);
		}

	}

}
