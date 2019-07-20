package com.hackerhank.daysofcodehackerhank.day_07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InverseArrayTest {

	@Test
	public void inverseArrayTest() {
		int[] arrTest1 = {1,4,3,2,5};
		int[] arrTest2 = {1,4,3,2};
		
		Assertions.assertArrayEquals(new int[] {5, 2, 3, 4, 1}, InverseArray.inverseArray(arrTest1));
		Assertions.assertArrayEquals(arrTest1, InverseArray.inverseArray(arrTest1));
		Assertions.assertArrayEquals(new int[] {2, 3, 4, 1}, InverseArray.inverseArray(arrTest2));
		Assertions.assertArrayEquals(arrTest2, InverseArray.inverseArray(arrTest2));
	}
}
