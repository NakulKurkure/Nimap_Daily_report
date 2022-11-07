package com.job.validation;

public class RandomPassword {
	public String randomPassword() {
	    System.out.println("Generating Password");

	    String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&?{}*";
	    StringBuilder builder = new StringBuilder();

	    int count = 8;

	    while (count-- != 0) {
	        int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
	        builder.append(ALPHA_NUMERIC_STRING.charAt(character));
	    }
	    return builder.toString();

	}
}

