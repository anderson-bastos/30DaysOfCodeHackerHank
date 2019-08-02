package com.hackerhank.daysofcodehackerhank.day_20;

public class BubbleSort {

	private BubbleSort() {
		throw new IllegalStateException("Utility class");
	}
	
	public static int getNumberOfSwaps(int[] arr) {
		int n = arr.length;
		int numberTotalOfSwaps = 0;
		for (int i = 0; i < n; i++) {
			int numberOfSwaps = 0;
			for (int j = 0; j < n - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr[j], arr[j + 1]);
					numberOfSwaps++;					
				}
			}			
			if (numberOfSwaps == 0)
				break;			
			numberTotalOfSwaps+=numberOfSwaps;
		}
		return numberTotalOfSwaps;
	}

	private static void swap(int i, int j) {
		int aux = i;
		i = j;
		j = aux;
	}
}
