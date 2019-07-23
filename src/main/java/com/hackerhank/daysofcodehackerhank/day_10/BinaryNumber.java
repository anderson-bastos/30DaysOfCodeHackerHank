package com.hackerhank.daysofcodehackerhank.day_10;

public class BinaryNumber {

	private BinaryNumber() {
		throw new IllegalStateException("Utility class");
	}
	
	public static int calculateConsecutiveOnesBinaryNumber(int number) {
		String binaryNumber = Integer.toBinaryString(number);
		int count = 0;
		int maxOnes = 1;
		for (int i = 0; i < binaryNumber.length(); i++) {
			if(binaryNumber.charAt(i) == '1'){
				++count;
				if(count > maxOnes) 
					maxOnes = count;
				continue;
			}
			count=0;
		}
		return maxOnes;
	}
}
