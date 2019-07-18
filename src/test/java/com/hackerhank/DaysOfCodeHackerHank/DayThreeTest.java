package com.hackerhank.DaysOfCodeHackerHank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hackerhank.daysofcodehackerhank.day_03.DayThree;

public class DayThreeTest {	
	
	@DisplayName("Day Three Test - Check id number is Odd")
	@Test
	public void checkIfWeirdNumberIsOddTest() {
		Assertions.assertEquals(DayThree.WEIRD, DayThree.checkIfWeirdNumber(1));
		Assertions.assertEquals(DayThree.NOT_WEIRD, DayThree.checkIfWeirdNumber(2));
		Assertions.assertEquals(DayThree.WEIRD, DayThree.checkIfWeirdNumber(3));
	}
	
	@DisplayName("Day Three Test - Check id number is even and in the inclusive range of 2 to 5")
	@Test
	public void checkIfWeirdNumberIsEvenAndInInclusiveRangeTest() {
		Assertions.assertEquals(DayThree.NOT_WEIRD, DayThree.checkIfWeirdNumber(2));
		Assertions.assertEquals(DayThree.WEIRD, DayThree.checkIfWeirdNumber(3));
		Assertions.assertEquals(DayThree.NOT_WEIRD, DayThree.checkIfWeirdNumber(4));
		Assertions.assertEquals(DayThree.WEIRD, DayThree.checkIfWeirdNumber(5));
	}
	
	@DisplayName("Day Three Test - Check id number is even and in the inclusive range of 6 to 20")
	@Test
	public void checkIfWeirdNumberIsEvenAndInInclusiveRangeTwoTest() {
		Assertions.assertEquals(DayThree.WEIRD, DayThree.checkIfWeirdNumber(6));
		Assertions.assertEquals(DayThree.WEIRD, DayThree.checkIfWeirdNumber(12));
		Assertions.assertEquals(DayThree.WEIRD, DayThree.checkIfWeirdNumber(18));
		Assertions.assertEquals(DayThree.WEIRD, DayThree.checkIfWeirdNumber(20));
	}
	
	@DisplayName("Day Three Test - Check id number is even and greater than 20")
	@Test
	public void checkIfWeirdNumberIsEvenAndGreaterThanTwelveTest() {
		Assertions.assertEquals(DayThree.WEIRD, DayThree.checkIfWeirdNumber(21));
		Assertions.assertEquals(DayThree.NOT_WEIRD, DayThree.checkIfWeirdNumber(22));
		Assertions.assertEquals(DayThree.NOT_WEIRD, DayThree.checkIfWeirdNumber(40));
	}
}
