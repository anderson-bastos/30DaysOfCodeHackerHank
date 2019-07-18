package com.hackerhank.daysofcodehackerhank.day_05;

import java.util.stream.IntStream;

public class Loop {
	
	private Loop() {
		throw new IllegalStateException("Utility class");
	}
	
	public static void loopMultiples(int number) {
		IntStream.range(1, 11).forEach(x -> System.out.printf("%d x %d = %d %n", number, x, number*x));
	}
}
