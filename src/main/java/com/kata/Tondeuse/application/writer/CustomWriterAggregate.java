package com.kata.Tondeuse.application.writer;

import org.springframework.batch.item.file.transform.LineAggregator;

import com.kata.Tondeuse.application.ports.ResultWriterPort;
import com.kata.Tondeuse.domain.model.Position;

public class CustomWriterAggregate implements LineAggregator<Position> , ResultWriterPort {

	@Override
	public String aggregate(Position item) {
		return write(item);
	}

	@Override
	public String write(Position finalPosition) {
		StringBuilder result = new StringBuilder ("position final :");
		result.append(finalPosition.toString());
		result.append("\n");
		
		return result.toString(); 
	}

}
