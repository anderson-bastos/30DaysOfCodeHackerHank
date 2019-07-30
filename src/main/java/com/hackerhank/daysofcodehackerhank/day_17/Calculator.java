package com.hackerhank.daysofcodehackerhank.day_17;

public class Calculator {
	
	public int power(int n, int p) {
		if (n < 0 || p < 0)
			throw new IllegalArgumentException("n and p should be non-negative");
		return calculatePower(n, p);
	}

	private int calculatePower(int n, int p) {
		if (p == 0)
			return 1;
		return n * calculatePower(n, p - 1);
	}
}
