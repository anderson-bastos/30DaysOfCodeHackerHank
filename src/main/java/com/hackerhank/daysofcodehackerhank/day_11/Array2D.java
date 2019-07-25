package com.hackerhank.daysofcodehackerhank.day_11;

public class Array2D {

	private Array2D() {
		throw new IllegalStateException("Utility class");
	}
	
	public static int maxArray2D(int[][] arr) {		
		int sumElements = 0;
	    int sumMax = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				sumElements = sumElementsArray(arr, i, j);
	            if(sumElements > sumMax || (i==0 && j==0))
	            	sumMax = sumElements;
			}			
		}
		return sumMax;
	}

	private static int sumElementsArray(int[][] arr, int i, int j) {
		return arr[i][j] + arr[i][j+1] + arr[i][j+2]
		        + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1]
		        + arr[i+2][j+2];
	}
	
	
}
