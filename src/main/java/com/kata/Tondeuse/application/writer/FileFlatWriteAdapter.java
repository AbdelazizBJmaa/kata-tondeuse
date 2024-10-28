package com.kata.Tondeuse.application.writer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.core.io.FileSystemResource;

import com.kata.Tondeuse.domain.model.Position;


public class FileFlatWriteAdapter extends FlatFileItemWriter<Position>{

	Logger logger = LoggerFactory.getLogger(FileFlatWriteAdapter.class);
	private final String PATTERN_YYYY_MM_DD_HH_MM_SS = "YYYY_MM_dd_HH_mm_ss";
	public FileFlatWriteAdapter(String fileOutput) {
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_YYYY_MM_DD_HH_MM_SS);		
		setName("TondeuseItemWriter");
		setResource(new FileSystemResource(fileOutput+"_"+localDateTime.format(formatter)+".txt"));
		setLineAggregator(new CustomWriterAggregate());
	}
	
	
	

}
