package com.hackerhank.daysofcodehackerhank.day_26;

import java.time.LocalDate;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.hackerhank.daysofcodehackerhank.util.FileTestCaseUtil;

public class NestedLogicTest {
	
	@Test
	public void getHackosByDateReceivedTest() {
		LocalDate[] input = loadFileInput("input02.txt");
		int expected = loadFileOutput("output02.txt");
		
		Assertions.assertEquals(expected, NestedLogic.getHackosByDateReceived(input[1], input[0]));
	}
		
	private static LocalDate[] loadFileInput(String fileName) {
		Scanner scanner = FileTestCaseUtil.getFileFromResources("day_26/input/" + fileName);
		LocalDate[] input = new LocalDate[2];
		
		String[] firstDate = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int[] dateOne = new int[3];
		for (int i = 0; i < firstDate.length; i++) {
			dateOne[i] = Integer.parseInt(firstDate[i]);
		}		
		input[0] = LocalDate.of(dateOne[2], dateOne[1], dateOne[0]);
		
		String[] secondDate = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int[] dateTwo = new int[3];
		for (int i = 0; i < secondDate.length; i++) {
			dateTwo[i] = Integer.parseInt(secondDate[i]);
		}		
		input[1] = LocalDate.of(dateTwo[2], dateTwo[1], dateTwo[0]);		
		
		scanner.close();
		return input;
	}

	private static int loadFileOutput(String fileName) {
		Scanner scanner = FileTestCaseUtil.getFileFromResources("day_26/output/" + fileName);
		int output = scanner.nextInt();
		scanner.close();
		return output;
	}
}
