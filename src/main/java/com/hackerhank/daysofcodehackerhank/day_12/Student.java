package com.hackerhank.daysofcodehackerhank.day_12;

import java.util.Arrays;

public class Student extends Person {
	
	private int[] testScores;

	public Student(String firstName, String lastName, int identification, int[] testScores) {
		super(firstName, lastName, identification);
		this.testScores = testScores;
	}
	
	private double calculateAveragePoints() {
		int scores = this.testScores.length;
		return Arrays.stream(this.testScores).sum()/scores;
	}

	private char getScale(double averageScores) {
		if(averageScores >= 90 && averageScores <= 100)
			return 'O';
		if(averageScores >= 80 && averageScores <= 90)
			return 'E';
		if(averageScores >= 70 && averageScores <= 80)
			return 'A';
		if(averageScores >= 55 && averageScores <= 70)
			return 'P';
		if(averageScores >= 40 && averageScores <= 55)
			return 'D';		
		return 'T';
	}
	
	public char calculate() {
		double averageScores = calculateAveragePoints();
		return getScale(averageScores);
	}
}
