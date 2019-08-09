package com.hackerhank.daysofcodehackerhank.day_25;

import java.time.Duration;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.hackerhank.daysofcodehackerhank.util.FileTestCaseUtil;

@TestMethodOrder(OrderAnnotation.class)
public class PrimeCheckTest {

	@Test
	@Order(0)
	public void checkIfNumberIsPrimeTestZero() {
		int[] input = loadFileInput("input00.txt");
		String[] expected = loadFileOutput("output00.txt", input.length);
		
		performanceTest(input);
		Assertions.assertArrayEquals(expected, PrimeCheck.checkIfNumbersIsPrime(input));
	}

	@Test
	@Order(1)
	public void checkIfNumberIsPrimeTestOne() {
		int[] input = loadFileInput("input01.txt");
		String[] expected = loadFileOutput("output01.txt", input.length);
		
		performanceTest(input);
		Assertions.assertArrayEquals(expected, PrimeCheck.checkIfNumbersIsPrime(input));
	}
	
	@Test
	@Order(2)
	public void checkIfNumberIsPrimeTestFive() {
		int[] input = loadFileInput("input05.txt");
		String[] expected = loadFileOutput("output05.txt", input.length);
		
		performanceTest(input);
		Assertions.assertArrayEquals(expected, PrimeCheck.checkIfNumbersIsPrime(input));
	}
	
	@Test
	@Order(3)
	public void checkIfNumberIsPrimeTestSeven() {
		int[] input = loadFileInput("input07.txt");
		String[] expected = loadFileOutput("output07.txt", input.length);
		
		performanceTest(input);
		Assertions.assertArrayEquals(expected, PrimeCheck.checkIfNumbersIsPrime(input));
	}
	
	@Test
	@Order(4)
	public void checkIfNumberIsPrimeTestEight() {
		int[] input = loadFileInput("input08.txt");
		String[] expected = loadFileOutput("output08.txt", input.length);
		
		performanceTest(input);
		Assertions.assertArrayEquals(expected, PrimeCheck.checkIfNumbersIsPrime(input));
	}
	
	private void performanceTest(int[] input) {
		// Half second
		Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			PrimeCheck.checkIfNumbersIsPrime(input);
		});
	}
	
	private static int[] loadFileInput(String fileName) {
		Scanner scanner = FileTestCaseUtil.getFileFromResources("day_25/input/" + fileName);		
		int n = scanner.nextInt();
		int[] input = new int[n];
		for(int i=0; i < n; i++){
			input[i] = scanner.nextInt();
		}
		scanner.close();
		return input;
	}

	private static String[] loadFileOutput(String fileName, int numberInputs) {
		Scanner scanner = FileTestCaseUtil.getFileFromResources("day_25/output/" + fileName);		
		String[] expected = new String[numberInputs];
		for(int i=0; i < numberInputs; i++){
			expected[i] = scanner.nextLine();
		}		
		scanner.close();
		return expected;
	}
}
