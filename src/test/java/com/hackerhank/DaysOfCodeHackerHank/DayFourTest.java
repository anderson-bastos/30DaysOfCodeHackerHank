package com.hackerhank.DaysOfCodeHackerHank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DayFourTest {
	
	@DisplayName("Day Four")
	@Test
	public void teenagerTest() {
		DayFour dayFourTeenager = new DayFour(10); 
		Assertions.assertEquals(DayFour.YOUNG, dayFourTeenager.checkamIOld());		
		
		incrementYear(dayFourTeenager, 3);		
		Assertions.assertEquals(DayFour.TEENAGER, dayFourTeenager.checkamIOld());
		
		incrementYear(dayFourTeenager, 4);		
		Assertions.assertEquals(DayFour.TEENAGER, dayFourTeenager.checkamIOld());
		
		dayFourTeenager.yearPasses();		
		Assertions.assertEquals(DayFour.OLD, dayFourTeenager.checkamIOld());
	}

	private void incrementYear(DayFour dayFourTeenager, int years) {
		for (int i = 0; i < years; i++) {
			dayFourTeenager.yearPasses();
		}
	}
}
