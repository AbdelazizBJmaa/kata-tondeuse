package com.kata.Tondeuse.application.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.core.io.FileSystemResource;

public class InstructionFileReaderAdapter extends FlatFileItemReader<Object> {

	Logger logger = LoggerFactory.getLogger(InstructionFileReaderAdapter.class);
    
    public InstructionFileReaderAdapter(String fileInput) {
		setResource(new FileSystemResource(fileInput));
		setName("TondeuseItemReader");
		setLineMapper(new CustomLineMapper());		
	} 
	



}
