package com.hackerhank.daysofcodehackerhank.day_29;

public class Bitwise {
	
	private Bitwise() {
		throw new IllegalStateException("Utility class");
	}
	
	public static int getMaximumPossible(int n, int k) {
		 if(((k-1)|k) > n && k%2==0)
             return k-2;
         return k-1;
	}
}
