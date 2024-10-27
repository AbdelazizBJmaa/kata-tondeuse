package com.kata.Tondeuse.application.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.LineMapper;

import com.kata.Tondeuse.application.parse.InstructionParse;
import com.kata.Tondeuse.application.parse.LawnParser;
import com.kata.Tondeuse.application.parse.PositionParse;
import com.kata.Tondeuse.domain.model.Lawn;
import com.kata.Tondeuse.domain.model.Position;

public class CustomLineMapper implements LineMapper<Object> {

	private Logger logger = LoggerFactory.getLogger(CustomLineMapper.class);
	
	@Override
	public Object mapLine(String line, int lineNumber) throws Exception {
		if (lineNumber == 1) {
			Lawn lawn = new LawnParser(line).parse();
			logger.info("LAWN : " +lawn.toString());
			return lawn;
		} else if (lineNumber % 2 == 0) {
			Position startPosition = new PositionParse(line).parse();
			logger.info("Position :" + startPosition.toString());
			return startPosition;
		} else {
			String instruction = new InstructionParse(line).parse();
			return instruction;
		}
	}

}
