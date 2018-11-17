package com.itemsharing.userservice.utility;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtility {
	private static final String SALT = "toot";
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
	}
	
	@Bean
	public static String randomPassword() {
		String validChars = "ABCDEFG.-1234567890";
		StringBuilder newPass = new StringBuilder();
		
		Random rnd = new Random();
		
		while (newPass.length() < 10) {
			int index = (int) (rnd.nextFloat() * validChars.length());
			newPass.append(validChars.charAt(index));
		}
		
		return newPass.toString();
	}
}
