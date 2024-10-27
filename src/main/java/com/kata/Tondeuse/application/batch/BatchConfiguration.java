package com.kata.Tondeuse.application.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.kata.Tondeuse.application.model.MowerInstruction;
import com.kata.Tondeuse.application.processor.MowerProcessingAdapter;
import com.kata.Tondeuse.application.reader.InstructionFileReaderAdapter;
import com.kata.Tondeuse.application.writer.FileFlatWriteAdapter;
import com.kata.Tondeuse.domain.model.Position;

@Configuration
public class BatchConfiguration {

	
	@Value("${file.input}")
	private String fileInput;
	
	@Value("${file.output}")
	private String fileOutput;
	
	@Bean
	public FlatFileItemReader<Object> reader() {
		return new InstructionFileReaderAdapter(fileInput);
	}

	@Bean
	public MowerProcessingAdapter processor() {
		return new MowerProcessingAdapter();
	}

	@Bean
	public FlatFileItemWriter<Position> write() {
		return new FileFlatWriteAdapter(fileOutput);
	}
	
	@Bean
    public Job tondeuseJob(JobRepository jobRepository, Step step) {
        return new JobBuilder("tondeuseJob", jobRepository)
                .start(step)
                .build();
    }
	
	@Bean
    public Step step(JobRepository jobRepository, DataSourceTransactionManager transactionManager,
                      FlatFileItemReader<Object> reader, MowerProcessingAdapter processor, FlatFileItemWriter<Position> writer) {
        return new StepBuilder("step", jobRepository)
                .<Object, Position> chunk(10, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

}
