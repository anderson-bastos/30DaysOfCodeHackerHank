package com.hackerhank.daysofcodehackerhank.day_17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	private static final String N_AND_P_SHOULD_BE_NON_NEGATIVE = "n and p should be non-negative";

	@Test
	public void powerTestFirstArgumentsNegative() {
		IllegalArgumentException iae = powerIllegalArgumentExceptionTest(-2, 4);
		Assertions.assertEquals(N_AND_P_SHOULD_BE_NON_NEGATIVE, iae.getMessage());
	}

	@Test
	public void powerTestSecondArgumentsNegative() {
		IllegalArgumentException iae = powerIllegalArgumentExceptionTest(2, -4);
		Assertions.assertEquals(N_AND_P_SHOULD_BE_NON_NEGATIVE, iae.getMessage());
	}

	@Test
	public void powerTestBothArgumentsNegative() {
		IllegalArgumentException iae = powerIllegalArgumentExceptionTest(-2, -4);
		Assertions.assertEquals(N_AND_P_SHOULD_BE_NON_NEGATIVE, iae.getMessage());
	}

	private IllegalArgumentException powerIllegalArgumentExceptionTest(int n, int p) {
		Calculator c = new Calculator();
		IllegalArgumentException iae = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			c.power(n, p);
		});
		return iae;
	}

	@Test
	public void calculatePower() {
		Calculator c = new Calculator();
		Assertions.assertEquals(243, c.power(3, 5));
		Assertions.assertEquals(16, c.power(2, 4));
		Assertions.assertEquals(1, c.power(10, 0));
		Assertions.assertEquals(0, c.power(0, 10));
		Assertions.assertEquals(15625, c.power(5, 6));
		Assertions.assertEquals(27, c.power(3, 3));
		Assertions.assertEquals(1, c.power(8, 0));
		Assertions.assertEquals(8, c.power(2, 3));
	}

}
