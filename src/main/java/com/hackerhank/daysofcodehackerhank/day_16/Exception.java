package com.hackerhank.daysofcodehackerhank.day_16;

import java.util.Scanner;

public class Exception {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String S = in.next();
		in.close();
		try {
			int number = Integer.parseInt(S);
			System.out.println(number);
		} catch (NumberFormatException nfe) {
			System.out.println("Bad String.");
		}
	}
}
