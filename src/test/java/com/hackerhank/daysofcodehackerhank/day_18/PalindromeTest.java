package com.hackerhank.daysofcodehackerhank.day_18;

import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.hackerhank.daysofcodehackerhank.util.FileTestCaseUtil;

@TestMethodOrder(OrderAnnotation.class)
public class PalindromeTest {

	@Test
	@Order(0)
	public void palindromeTestZero() {
		String input = loadFileInput("input00.txt"); 
		String expected = loadFileOutput("output00.txt");

		String actual = checkIfIsPalindromeTest(input);
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	@Order(1)
	public void palindromeTestOne() {
		String input = loadFileInput("input01.txt"); 
		String expected = loadFileOutput("output01.txt");
		
		String actual = checkIfIsPalindromeTest(input);		
		Assertions.assertEquals(expected, actual);
	}
	
	private static String loadFileInput(String fileName) {
		Scanner scanner = FileTestCaseUtil.getFileFromResources("day_18/input/" + fileName);
		String input = scanner.nextLine();
		scanner.close();
		return input;
	}
	
	private static String loadFileOutput(String fileName) {
		Scanner scanner = FileTestCaseUtil.getFileFromResources("day_18/output/" + fileName);		
		String output = scanner.nextLine();
		scanner.close();
		return output;
	}

	private String checkIfIsPalindromeTest(String input) {
		char[] s = input.toCharArray();
        Palindrome palindrome = new Palindrome();

        for (char c : s) {
            palindrome.pushCharacter(c);
            palindrome.enqueueCharacter(c);
        }

        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (palindrome.popCharacter() != palindrome.dequeueCharacter()) {
                isPalindrome = false;                
                break;
            }
        }        
        return "The word, " + input + ", is " + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." );		
	}
}
