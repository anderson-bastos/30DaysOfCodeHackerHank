package com.hackerhank.DaysOfCodeHackerHank;

import java.util.stream.IntStream;

public class DayThree {	
	public static final String WEIRD = "Weird";
	public static final String NOT_WEIRD = "Not Weird";
	
	private DayThree() {
		throw new IllegalStateException();
	}
	
	private static boolean isOddNumber(int number) {
		return number % 2 != 0;
	}
	
	private static boolean contains(IntStream rangeInterval, final int key) {     
		return rangeInterval.anyMatch(x -> x == key);
	}
	
	public static String checkIfWeirdNumber(int number) {
		Boolean isOddNumber = isOddNumber(number);		
		if(isOddNumber)
			return WEIRD;
		
		if(contains(IntStream.range(2, 6), number))
			return NOT_WEIRD;
		
		if(contains(IntStream.range(6, 21), number))
			return WEIRD;
		
		return NOT_WEIRD;
	}
}
