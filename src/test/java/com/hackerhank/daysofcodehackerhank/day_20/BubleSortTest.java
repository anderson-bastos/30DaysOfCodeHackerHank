package com.hackerhank.daysofcodehackerhank.day_20;

import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.hackerhank.daysofcodehackerhank.util.FileTestCaseUtil;

public class BubleSortTest {

	private static String NUMBER_SWAPS_FMT = "Array is sorted in %d swaps.";
	private static String FIRST_ELEMENT_FMT = "First Element: %d";
	private static String LAST_ELEMENT_FMT = "Last Element: %d";
	
	@Test
	public void sortTestZero() {
		int[] input = loadFileInput("input00.txt");
		String[] output = loadFileOutput("output00.txt");
		
		int numberOfSwaps = BubbleSort.getNumberOfSwaps(input);
		argumentsTest(input, output, numberOfSwaps);
	}
	
	@Test
	public void sortTestOne() {
		int[] input = loadFileInput("input01.txt");
		String[] output = loadFileOutput("output01.txt");
		
		int numberOfSwaps = BubbleSort.getNumberOfSwaps(input);
		argumentsTest(input, output, numberOfSwaps);
	}

	private void argumentsTest(int[] input, String[] output, int numberOfSwaps) {
		int lastElement = input.length-1;
		Assertions.assertEquals(output[0], String.format(NUMBER_SWAPS_FMT, numberOfSwaps));
		Assertions.assertEquals(output[1], String.format(FIRST_ELEMENT_FMT, input[0]));
		Assertions.assertEquals(output[2], String.format(LAST_ELEMENT_FMT, input[lastElement]));
	}
	
	private static int[] loadFileInput(String fileName) {
		Scanner scanner = FileTestCaseUtil.getFileFromResources("day_20/input/" + fileName);		
		int n = scanner.nextInt();
		int[] input = new int[n];
		for(int a_i=0; a_i < n; a_i++){
			input[a_i] = scanner.nextInt();
		}
		scanner.close();
		return input;
	}
	
	private static String[] loadFileOutput(String fileName) {
		Scanner scanner = FileTestCaseUtil.getFileFromResources("day_20/output/" + fileName);		
		String[] output = new String[3];
		output[0] = scanner.nextLine();
		output[1] = scanner.nextLine();
		output[2] = scanner.nextLine();
		scanner.close();
		return output;
	}

}
