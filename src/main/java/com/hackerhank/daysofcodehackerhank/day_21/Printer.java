package com.hackerhank.daysofcodehackerhank.day_21;

public class Printer<T> {

	public void printArray(T[] printer) {
		for (int i = 0; i < printer.length; i++) {
			System.out.println(printer[i]);
		}
	}
}
