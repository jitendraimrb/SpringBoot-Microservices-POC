package com.learning.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<ErrorResponseAPI> handleException(CategoryNotFoundException ex) {

		ErrorResponseAPI errorResponse = ErrorResponseAPI.builder().timeStaTime(LocalDateTime.now())
				.httpStatus(HttpStatus.BAD_REQUEST).code(HttpStatus.BAD_REQUEST.value()).message("Client Error")
				.details(Collections.singletonList(ex.getMessage())).build();

		return new ResponseEntity<ErrorResponseAPI>(errorResponse, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(ProdutNotFoundException.class)
	public ResponseEntity<ErrorResponseAPI> handleExceptoin(ProdutNotFoundException ex) {

		ErrorResponseAPI errorResponse = ErrorResponseAPI.builder().timeStaTime(LocalDateTime.now())
				.httpStatus(HttpStatus.INTERNAL_SERVER_ERROR).code(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.message("Something went wrong").details(Collections.singletonList(ex.getMessage())).build();

		return new ResponseEntity<ErrorResponseAPI>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseAPI> handleException(Exception ex) {

		ErrorResponseAPI errorResponse = ErrorResponseAPI.builder().timeStaTime(LocalDateTime.now())
				.httpStatus(HttpStatus.INTERNAL_SERVER_ERROR).code(HttpStatus.BAD_REQUEST.value())
				.message("Something is wrong").details(Collections.singletonList(ex.getMessage())).build();

		return new ResponseEntity<ErrorResponseAPI>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		 List<String> details  = new ArrayList<>();
		 List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
		 
		 for(ObjectError error : errorList) {
			 details.add(error.getDefaultMessage());
		 }
		 
		ErrorResponseAPI errorResponse = ErrorResponseAPI.builder().timeStaTime(LocalDateTime.now())
				.httpStatus(HttpStatus.INTERNAL_SERVER_ERROR).code(HttpStatus.BAD_REQUEST.value())
				.message("Validation error").details(details).build();

		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
