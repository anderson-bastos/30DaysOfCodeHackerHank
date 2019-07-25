package com.hackerhank.daysofcodehackerhank.day_12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentTest {

	private Student studentOne;
	private Student studentTwo;
	private Student studentThree;
	private Student studentFour;
	private Student studentFive;
	private Student studentSix;

	@BeforeEach
	public void init() {
		int[] testScores = { 100, 80 };
		studentOne = new Student("Heraldo", "Memelli", 81366227, testScores);

		testScores = new int[] { 31, 32, 34, 35 };
		studentTwo = new Student("Aakansha", "Doshi", 7825621, testScores);
		
		testScores = new int[] {100, 90, 80, 75, 90, 88, 84, 88, 78, 67 };
		studentThree = new Student("Kathryn", "Hodge", 8292157, testScores);
		
		testScores = new int[] {100, 50, 70, 60, 80, 60 };
		studentFour = new Student("Kathryn", "Hodge", 8292157, testScores);
		
		testScores = new int[] { 40, 60, 54, 70 };
		studentFive = new Student("Satish", "Pandey", 7826099, testScores);
		
		testScores = new int[] { 41, 42, 43, 44, 45, 46, 48 };
		studentSix = new Student("Sancho", "Panza", 4847677, testScores);
	}

	@Test
	public void calculateTest() {
		Assertions.assertEquals('O', studentOne.calculate());
		Assertions.assertEquals('T', studentTwo.calculate());
		Assertions.assertEquals('E', studentThree.calculate());
		Assertions.assertEquals('A', studentFour.calculate());
		Assertions.assertEquals('P', studentFive.calculate());
		Assertions.assertEquals('D', studentSix.calculate());
	}
}
