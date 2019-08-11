package com.hackerhank.daysofcodehackerhank.day_28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Regex {
	
	static final String PATTERN_GMAIL = "\\w+@gmail.com$";

	private Regex() {
		throw new IllegalStateException("Utility class");
	}
	
	public static List<String> checkWithGmail(Contact[] contacts) {
		ArrayList<String> gmailContacts = new ArrayList<>();
		for (int i = 0; i < contacts.length; i++) {
			if(matchEmail(contacts[i].email))
				gmailContacts.add(contacts[i].name);
		}
		Collections.sort(gmailContacts);
        return gmailContacts;
    }
	
	private static boolean matchEmail(String email) {
		  return Pattern
				  .compile(PATTERN_GMAIL)
				  .matcher(email)
				  .find();
	}
}
