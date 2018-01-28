package demo.date.time.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class FormattingAndParsingDemo {
	public static void main(String[] args) {
		// 2014-04-01 10:45
		LocalDateTime dateTime = LocalDateTime.of(2014, Month.APRIL, 1, 10, 45);
		System.out.println(dateTime);
		
		// Format as basic ISO date format (20140220)
		String asBasicIsoDate = dateTime.format(DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println(asBasicIsoDate);
		
		// Format as ISO week date (2014-W08-4)
		String asIsoWeekDate = dateTime.format(DateTimeFormatter.ISO_WEEK_DATE);
		System.out.println(asIsoWeekDate);
		
		// Format ISO date time (2014-02-20T20:04:05.867)
		String asIsoDateTime = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
		System.out.println(asIsoDateTime);
		
		// Using a custom pattern (01/04/2014)
		String asCustomPattern = dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(asCustomPattern);
		
		// French date formatting (1. avril 2014)
		String frenchDate = dateTime.format(DateTimeFormatter.ofPattern("d. MMMM yyyy", new Locale("fr")));
		System.out.println(frenchDate);
		
		// using short german date/time formatting (01.04.14 10:45)
		DateTimeFormatter formatter = DateTimeFormatter
										.ofLocalizedDateTime(FormatStyle.SHORT)
										.withLocale(new Locale("de"));
		String germanDateTime = dateTime.format(formatter);
		System.out.println(germanDateTime);
		
		// parsing date strings
		LocalDate fromIsoDate = LocalDate.parse("2014-01-20");
		System.err.println(fromIsoDate);
		
		LocalDate fromIsoWeekDate = LocalDate.parse("2014-W14-2", DateTimeFormatter.ISO_WEEK_DATE);
		System.out.println(fromIsoWeekDate);
		
		LocalDate fromCustomPattern = LocalDate.parse("20.01.2014", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		System.out.println(fromCustomPattern);
	}
}