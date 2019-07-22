package com.hackerhank.daysofcodehackerhank.day_09;

public class Recursion {
	
	private Recursion() {
		throw new IllegalStateException("Utility class");
	}
	
    static int factorial(int n) {
    	if(n <= 1)
    		return 1;
    	return n * factorial(n-1);
    }
}
