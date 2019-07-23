package com.hackerhank.daysofcodehackerhank.day_09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecursionTest {

	@Test
	public void factorialTest() {
		Assertions.assertEquals(6, Recursion.factorial(3));
		Assertions.assertEquals(24, Recursion.factorial(4));
		Assertions.assertEquals(120, Recursion.factorial(5));
		Assertions.assertEquals(720, Recursion.factorial(6));
		Assertions.assertEquals(5040, Recursion.factorial(7));
		Assertions.assertEquals(40320, Recursion.factorial(8));
		Assertions.assertEquals(362880, Recursion.factorial(9));
		Assertions.assertEquals(3628800, Recursion.factorial(10));
	}
}
