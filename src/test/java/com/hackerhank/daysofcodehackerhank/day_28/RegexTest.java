package com.hackerhank.daysofcodehackerhank.day_28;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.hackerhank.daysofcodehackerhank.util.FileTestCaseUtil;

public class RegexTest {
	
	@Test
	public void checkWithGmailTest() {
		Contact[] input = loadFileInput("input00.txt");
		List<String> expected = loadFileOutput("output00.txt");
		
		Assertions.assertEquals(expected, Regex.checkWithGmail(input));
	}

	private static Contact[] loadFileInput(String fileName) {
		Scanner scanner = FileTestCaseUtil.getFileFromResources("day_28/input/" + fileName);
		int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Contact[] contacts = new Contact[N];
        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");
            contacts[NItr] = new Contact(firstNameEmailID[0], firstNameEmailID[1]);
        }
        scanner.close();
		return contacts;
	}

	private static ArrayList<String> loadFileOutput(String fileName) {
		Scanner scanner = FileTestCaseUtil.getFileFromResources("day_28/output/" + fileName);
		ArrayList<String> output = new ArrayList<>();
		while(scanner.hasNextLine()) {
			output.add(scanner.nextLine());
		}		
		scanner.close();
		return output;
	}
}
