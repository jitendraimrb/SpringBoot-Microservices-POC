package com.example.config;

import javax.batch.api.chunk.ItemProcessor;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.example.models.Customer;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@EnableBatchProcessing
public class BatchConfiguration {
	
	@Autowired
	private JobBuilderFactory builderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job job(ItemReader<Customer> reader, org.springframework.batch.item.ItemProcessor<Customer, Customer> processor,
			ItemWriter<Customer> writer) {
		
		Step step = stepBuilderFactory.get("csv-step").<Customer, Customer>chunk(50)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.faultTolerant()
				.skipLimit(3)
				.skip(Exception.class)
				.build();
		
		return builderFactory.get("importCustomers")
				.incrementer(new RunIdIncrementer())
				.start(step)
				.build();
	}

	@Bean
	public FlatFileItemReader<Customer> itemReader(){
		
		FlatFileItemReader<Customer> flatFileItemReader = new FlatFileItemReader<Customer>();
		
		flatFileItemReader.setResource(new FileSystemResource("src/main/resources/input.csv"));
		flatFileItemReader.setName("csvReader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(linemapper());
		
		return flatFileItemReader;
		
		
	}

	@Bean
	public LineMapper<Customer> linemapper() {
		
		DefaultLineMapper<Customer> defaultLineMapper = new DefaultLineMapper<>();
		
		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
		
		delimitedLineTokenizer.setDelimiter(",");
		delimitedLineTokenizer.setNames("id","firstName","lastName","email","gender","contactNo","country","dob","status");
		
		delimitedLineTokenizer.setStrict(false);
		
		BeanWrapperFieldSetMapper<Customer> fieldSetMapper = new BeanWrapperFieldSetMapper();
		fieldSetMapper.setTargetType(Customer.class);
		
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
		
		
		
		// TODO Auto-generated method stub
		return defaultLineMapper;
	}
}
