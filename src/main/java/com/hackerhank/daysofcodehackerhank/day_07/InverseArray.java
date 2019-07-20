package com.hackerhank.daysofcodehackerhank.day_07;

public class InverseArray {

	private InverseArray() {
		throw new IllegalStateException("Utility class");
	}

	public static int[] inverseArray(int[] array) {
		int length = array.length;
		int mid = length / 2;
		for (int i = 0; i < mid; i++) {
			int aux = array[length - 1 - i];
			array[length - 1 - i] = array[i];
			array[i] = aux;
		}
		return array;
	}
}
