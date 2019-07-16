package com.hackerhank.DaysOfCodeHackerHank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DayTwoTest {
	
	@DisplayName("Day Two Teste")
	@Test
	public void totalCoastTest() {
		double actual = DayTwo.totalCoast(12.00, 20, 8);
		Assertions.assertEquals(15.0, actual);
	}
	
}
