package com.hackerhank.daysofcodehackerhank.day_02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hackerhank.daysofcodehackerhank.day_02.DayTwo;

public class DayTwoTest {
	
	@DisplayName("Day Two Test")
	@Test
	public void totalCoastTest() {
		double actual = DayTwo.totalCoast(12.00, 20, 8);
		Assertions.assertEquals(15.0, actual);
	}
	
}
