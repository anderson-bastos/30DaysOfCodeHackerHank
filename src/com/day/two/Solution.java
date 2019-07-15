package com.day.two;

import java.util.Scanner;

public class Solution {
	static void solve(double meal_cost, int tip_percent, int tax_percent) {
		double tip = calculatePercentage(meal_cost, tip_percent);
		double tax = calculatePercentage(meal_cost, tax_percent);		
		System.out.println(Math.round((meal_cost + tip + tax)));
    }

	private static double calculatePercentage(double mealCost, int valuePercentage) {
		return mealCost * (valuePercentage/100.0);
	}
	
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double meal_cost = scanner.nextDouble();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int tip_percent = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int tax_percent = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        solve(meal_cost, tip_percent, tax_percent);

        scanner.close();
    }
}
