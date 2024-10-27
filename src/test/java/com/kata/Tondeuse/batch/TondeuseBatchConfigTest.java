package com.kata.Tondeuse.batch;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBatchTest
@SpringBootTest
class TondeuseBatchConfigTest {

	  @Autowired
	  private JobLauncherTestUtils jobLauncherTestUtils;
	  
	  @Autowired
	  private Job tondeuseJob;
	
	@Test
	void testJob() throws Exception {
		 JobExecution jobExecution = jobLauncherTestUtils.launchJob();
	        
	     assertEquals("COMPLETED", jobExecution.getExitStatus().getExitCode());
	}

}
