package com.hackerhank.daysofcodehackerhank.day_14;

public class Difference {

	private int[] elements;
	public int maximumDifference;

	public Difference(int[] elements) {
		this.elements = elements;
		this.maximumDifference = 0;
	}

	public void computeDifference() {
		int n = elements.length;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n; j++) {
				int difference = calculateDifference(elements[i], elements[j]);
				if(difference > maximumDifference)
					maximumDifference = difference;
			}
		}
	}
	
	private int calculateDifference(int i, int j) {
		return i > j ? i - j : j - i;
	}
}
