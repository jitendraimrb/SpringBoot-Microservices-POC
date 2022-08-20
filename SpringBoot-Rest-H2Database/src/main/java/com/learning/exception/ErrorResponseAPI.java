package com.learning.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponseAPI {
	
	private HttpStatus httpStatus;
	private Integer code;
	private String message;
	private List<String> details;
	private LocalDateTime timeStaTime;
	
	

}
