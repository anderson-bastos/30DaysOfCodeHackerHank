package com.hackerhank.daysofcodehackerhank.day_10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryNumberTest {

	@Test
	public void calculateConsecutiveOnesBinaryNumber() {
		Assertions.assertEquals(1, BinaryNumber.calculateConsecutiveOnesBinaryNumber(5));
		Assertions.assertEquals(3, BinaryNumber.calculateConsecutiveOnesBinaryNumber(951));
		Assertions.assertEquals(3, BinaryNumber.calculateConsecutiveOnesBinaryNumber(1911));
		Assertions.assertEquals(16, BinaryNumber.calculateConsecutiveOnesBinaryNumber(65535));
		Assertions.assertEquals(16, BinaryNumber.calculateConsecutiveOnesBinaryNumber(262141));
	}
}
