package demo.date.time.api;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class LocalDateDemo {
	public static void main(String[] args) {
		// Current local date e.g. 2018-01-27
		System.out.println(LocalDate.now());

		// Max local date i.e. +999999999-12-31
		System.out.println(LocalDate.MAX);

		// Min local date i.e. -999999999-01-01
		System.out.println(LocalDate.MIN);

		// 2015-10-15
		System.out.println(LocalDate.of(2015, 10, 15));

		// 2017-01-15
		System.out.println(LocalDate.of(2017, Month.JANUARY, 15));

		// 5024th day since 1970-01-01 i.e. 1983-10-04
		System.out.println(LocalDate.ofEpochDay(5024));

		// ISO-8601 date format for 1947-08-15
		System.out.println(LocalDate.parse("1947-08-15"));

		// 50th day of year 2000 i.e. 2000-02-19
		LocalDate fiftythDayOf2000 = LocalDate.ofYearDay(2000, 50);
		System.out.println(fiftythDayOf2000);

		// Day of month i.e. 19
		System.out.println(fiftythDayOf2000.getDayOfMonth());

		// Day of year i.e. 50
		System.out.println(fiftythDayOf2000.getDayOfYear());

		// Day on 2000-02-19 i.e. SATURDAY
		// .name() and .toString() prints same value
		System.out.println(fiftythDayOf2000.getDayOfWeek().name());

		// SATURDAY's integer value i.e 6
		// Monday is 1 and Sunday is 7
		System.out.println(fiftythDayOf2000.getDayOfWeek().getValue());

		Month month = fiftythDayOf2000.getMonth();

		// FEBRUARY
		System.out.println(month.name());

		// 28
		System.out.println(month.minLength());

		// 29
		System.out.println(month.maxLength());

		// First month of the quarter i.e JANUARY
		System.out.println(month.firstMonthOfQuarter());

		// Is 2000 a current year? i.e. true
		System.out.println(fiftythDayOf2000.isLeapYear());

		// Date 50 days after 2000-02-19 i.e. 2000-04-09
		System.out.println(fiftythDayOf2000.plusDays(50));

		// 2000-03-04
		System.out.println(fiftythDayOf2000.plusWeeks(2));

		// Date six months before 2000-02-19 i.e. 1999-08-19
		System.out.println(fiftythDayOf2000.minus(6, ChronoUnit.MONTHS));

		LocalDate localDate1 = LocalDate.ofYearDay(2010, 50);
		LocalDate localDate2 = LocalDate.of(2010, 3, 5);

		// Is 2010-02-19 before 2010-03-05? true
		System.out.println(localDate1.isBefore(localDate2));

		// false
		System.out.println(localDate1.isAfter(localDate2));

		// 2010-04-19
		System.out.println(localDate1.withMonth(4));
	}
}