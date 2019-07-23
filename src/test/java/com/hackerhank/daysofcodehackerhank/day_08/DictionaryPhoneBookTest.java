package com.hackerhank.daysofcodehackerhank.day_08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DictionaryPhoneBookTest {

	@Test
	public void findContactTest() {
		DictionaryPhoneBook.insertContact("Anderson", 99999999);
		
		Assertions.assertEquals("Anderson=99999999", DictionaryPhoneBook.findContact("Anderson"));
		Assertions.assertEquals("Not found", DictionaryPhoneBook.findContact("Bastos"));
	}
}
