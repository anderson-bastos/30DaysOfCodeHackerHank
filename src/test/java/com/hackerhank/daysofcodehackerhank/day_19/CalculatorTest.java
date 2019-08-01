package com.hackerhank.daysofcodehackerhank.day_19;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	public void divisorSumTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(12, calculator.divisorSum(6));
		Assertions.assertEquals(1, calculator.divisorSum(1));
		Assertions.assertEquals(42, calculator.divisorSum(20));
		Assertions.assertEquals(465, calculator.divisorSum(200));
		Assertions.assertEquals(2340, calculator.divisorSum(1000));
		Assertions.assertEquals(102, calculator.divisorSum(101));
		Assertions.assertEquals(31, calculator.divisorSum(16));
	}
}
