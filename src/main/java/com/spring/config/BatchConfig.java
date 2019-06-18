package com.spring.config;

import org.springframework.batch.core.Job;



import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.spring.dao.impl.CustomerDaoImpl;
import com.spring.model.Utilisateur;
import com.spring.step.Listener;
import com.spring.step.Processor;
import com.spring.step.Reader;
import com.spring.step.Writer;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public CustomerDaoImpl customerDao;

	@Bean
	public Job job() {
		return jobBuilderFactory.get("job").incrementer(new RunIdIncrementer()).listener(new Listener(customerDao))
				.flow(step1()).end().build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<Utilisateur, Utilisateur>chunk(2)
				.reader(Reader.reader("customer-data.csv"))
				.processor(new Processor()).writer(new Writer(customerDao)).build();
	}
}
