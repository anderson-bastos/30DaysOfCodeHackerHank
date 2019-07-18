package com.hackerhank.daysofcodehackerhank.day_02;

public class DayTwo {
	
	private DayTwo() {
		throw new IllegalStateException();
	}
	
	public static double totalCoast(double mealCost, int tipPercent, int taxPercent) {
		double tip = calculatePercentage(mealCost, tipPercent);
		double tax = calculatePercentage(mealCost, taxPercent);		
		return Math.round((mealCost + tip + tax));
    }

	private static double calculatePercentage(double mealCost, int valuePercentage) {
		return mealCost * (valuePercentage/100.0);
	}
}
