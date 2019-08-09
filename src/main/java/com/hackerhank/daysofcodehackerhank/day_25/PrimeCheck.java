package com.hackerhank.daysofcodehackerhank.day_25;

import java.util.Arrays;

public class PrimeCheck {

	private PrimeCheck() {
		throw new IllegalStateException("Utility class");
	}

	public static String[] checkIfNumbersIsPrime(int[] numbers) {
		return Arrays.stream(numbers).mapToObj(PrimeCheck::checkNumber).toArray(String[]::new);
	}

	private static String checkNumber(int number) {
		boolean numberIsPrime = numberIsPrime(number);
		if (numberIsPrime)
			return "Prime";
		return "Not prime";
	}

	private static boolean numberIsPrime(int number) {
		if (number <= 1)
			return false;
		if (number <= 3)
			return true;
		if (number % 2 == 0 || number % 3 == 0)
			return false;
		for (int i = 5; i * i <= number; i = i + 6)
			if (number % i == 0 || number % (i + 2) == 0)
				return false;
		return true;
	}
}
