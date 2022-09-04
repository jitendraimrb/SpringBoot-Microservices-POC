package com.learning;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestEncodedPassword {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		System.out.println(bCryptPasswordEncoder.encode("Jitendra"));
		System.out.println(bCryptPasswordEncoder.encode("Amit"));
		System.out.println(bCryptPasswordEncoder.encode("Mohit"));
		
	}

}
