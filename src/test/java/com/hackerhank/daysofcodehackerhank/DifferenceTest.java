package com.hackerhank.daysofcodehackerhank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.hackerhank.daysofcodehackerhank.day_14.Difference;

public class DifferenceTest {
	
	@Test
	public void computeDifferenceTestCase1() {
		int[] arr = { 1, 2, 5 };
		Difference difference = new Difference(arr);
		difference.computeDifference();
		Assertions.assertEquals(4, difference.maximumDifference);
	}
	
	@Test
	public void computeDifferenceTestCase2() {
		int[] arr = { 8, 19, 3, 2, 7 };
		Difference difference = new Difference(arr) ;
		difference.computeDifference();
		Assertions.assertEquals(17, difference.maximumDifference);
	}
	
	@Test
	public void computeDifferenceTestCase3() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Difference difference = new Difference(arr);
		difference.computeDifference();
		Assertions.assertEquals(9, difference.maximumDifference);
	}
}
