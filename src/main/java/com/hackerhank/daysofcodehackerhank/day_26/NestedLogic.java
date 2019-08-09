package com.hackerhank.daysofcodehackerhank.day_26;

import java.time.LocalDate;

public class NestedLogic {

	private NestedLogic() {
		throw new IllegalStateException("Utility class");
	}

	public static int getHackosByDateReceived(LocalDate dateExpected, LocalDate dateReceived) {
		if (dateExpected.compareTo(dateReceived) > 0)
			return 0;

		int yearDiff = dateReceived.getYear() - dateExpected.getYear();
		if (yearDiff > 0)
			return 10000;

		int monthDiff = dateReceived.getMonthValue() - dateExpected.getMonthValue();
		if (monthDiff > 0)
			return 500 * monthDiff;

		int dayDiff = dateReceived.getDayOfMonth() - dateExpected.getDayOfMonth();
		if (dayDiff > 0)
			return 15 * dayDiff;
		return dayDiff;
	}
}
