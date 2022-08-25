package com.example.listeners;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomerChunkListener implements ChunkListener{
	
	
	@Override
	public void beforeChunk(ChunkContext context) {
		int count = context.getStepContext().getStepExecution().getReadCount();
		log.info("CustomerChunkListener :: beforeChunk:: {}",count);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChunk(ChunkContext context) {
		
		int count = context.getStepContext().getStepExecution().getReadCount();
		log.info("CustomerChunkListener :: afterChunk::  {}",count);
		
	}

	@Override
	public void afterChunkError(ChunkContext context) {
		// TODO Auto-generated method stub
		
	}

}
