package com.hackerhank.daysofcodehackerhank.day_06;

import java.util.Arrays;
import java.util.Scanner;

public class LetsReview {

	public static void formatSringArr(String[] text) {
		Arrays.stream(text).forEach(x -> System.out.println(formatSring(x)));
	}

	public static String formatSring(String text) {
		StringBuilder evenText = new StringBuilder();
		StringBuilder oddText = new StringBuilder();
		int textLength = text.length();

		for (int i = 0; i < textLength; i++) {
			if (i % 2 == 0)
				evenText.append(text.charAt(i));
			else
				oddText.append(text.charAt(i));
		}
		return String.format("%s %s", evenText.toString(), oddText.toString());
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int llistCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] arr = new String[llistCount];
		for (int i = 0; i < llistCount; i++) {
			String element = scanner.nextLine();
			arr[i] = element;
		}
		formatSringArr(arr);
	}
}
