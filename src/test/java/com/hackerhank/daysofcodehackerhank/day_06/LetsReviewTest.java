package com.hackerhank.daysofcodehackerhank.day_06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LetsReviewTest {

	@Test
	public void formatSringTest() {
		Assertions.assertEquals("Adro nesn", LetsReview.formatSring("Anderson"));
		Assertions.assertEquals("Bso ats", LetsReview.formatSring("Bastos"));
		Assertions.assertEquals("Hce akr", LetsReview.formatSring("Hacker"));
		Assertions.assertEquals("Rn ak", LetsReview.formatSring("Rank"));
	}
}
