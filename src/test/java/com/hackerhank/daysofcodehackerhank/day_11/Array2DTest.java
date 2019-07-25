package com.hackerhank.daysofcodehackerhank.day_11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Array2DTest {

	private static int[][] arrayTestCase1 = {	
		{1, 1, 1, 0, 0, 0},
		{0, 1, 0, 0, 0, 0},
		{1, 1, 1, 0, 0, 0},
		{0, 0, 2, 4, 4, 0},					
		{0, 0, 0, 2, 0, 0},
		{0, 0, 1, 2, 4, 0}};	
	
	private static int[][] arrayTestCase2 = {	
			{1, 1, 1, 0, 0, 0},
			{0, 1, 0, 0, 0, 0},
			{1, 1, 1, 0, 0, 0},
			{0, 9, 2, -4, -4, 0},					
			{0, 0, 0, -2, 0, 0},
			{0, 0, -1, -2, -4, 0}};
	
	@Test
	public void maxArray2DTest() {
		Assertions.assertEquals(19, Array2D.maxArray2D(arrayTestCase1));
		Assertions.assertEquals(13, Array2D.maxArray2D(arrayTestCase2));
	}
}
