package com.learning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
	
	
	@GetMapping("/search")
	public String fetch() {
		
		return "SearchController is not secured API";
	}

}
