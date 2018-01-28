package demo.date.time.api;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodDemo {
	public static void main(String[] args) {
		// 2010-05-17
		LocalDate firstDate = LocalDate.of(2010, 5, 17);
		System.out.println(firstDate);

		// 2015-03-07
		LocalDate secondDate = LocalDate.of(2015, 3, 7);
		System.out.println(secondDate);

		// P4Y9M18D
		Period period = Period.between(firstDate, secondDate);
		System.out.println(period);
		
		/** LocalDate method to calculate Period */
		// P4Y9M18D
		System.out.println(firstDate.until(secondDate));

		// 18
		System.out.println(period.getDays());

		// 9
		System.out.println(period.getMonths());

		// 4
		System.out.println(period.getYears());

		/** If day, month or year is negative this method will return true */
		// false
		System.out.println(period.isNegative());

		// 1755
		System.out.println(ChronoUnit.DAYS.between(firstDate, secondDate));

		// P2M5D
		Period twoMonthsAndFiveDays = Period.ofMonths(2).plusDays(5);
		System.out.println(twoMonthsAndFiveDays);

		// 2014-01-06
		LocalDate sixthOfJanuary = LocalDate.of(2014, 1, 6);
		System.out.println(sixthOfJanuary);

		// 2014-03-11
		LocalDate eleventhOfMarch = sixthOfJanuary.plus(twoMonthsAndFiveDays);
		System.out.println(eleventhOfMarch);
	}
}