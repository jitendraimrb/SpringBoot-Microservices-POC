package com.learning.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.learning.entity.Category;
import com.learning.entity.Product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface SwaggerInterface {
	
//	@ResponseStatus(code = HttpStatus.CREATED)
	@Operation(summary = "Responsible for inesrting the new records")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Productd has been created successfully", 
					content = @Content(mediaType = "application/json",
					schema = @Schema(implementation = Product.class)) ),
			@ApiResponse(responseCode = "401", description = "Unauthorized Access",content = @Content),
			@ApiResponse(responseCode = "403", description = "Forbidden access",content = @Content)
	})
	public ResponseEntity<String> saveCategoryRecords(@RequestBody Category category);

}