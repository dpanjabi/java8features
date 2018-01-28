package demo.date.time.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeDemo {
	public static void main(String[] args) {
		// 2018-01-28T12:04:38.541
		System.out.println(LocalDateTime.now());

		// +999999999-12-31T23:59:59.999999999
		System.out.println(LocalDateTime.MAX);

		// -999999999-01-01T00:00
		System.out.println(LocalDateTime.MIN);

		// 2011-11-11T11:11:11.001111111
		System.out.println(LocalDateTime.of(2011, Month.NOVEMBER, 11, 11, 11, 11, 1111111));

		// 2018-01-28T12:04:38.546
		System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.now()));

		// 2018-01-28
		System.out.println(LocalDateTime.now().toLocalDate());

		// 12:04:38.547
		System.out.println(LocalDateTime.now().toLocalTime());
		
		/** Use LocalDate method to create LocalDateTime object */
		// 2018-01-28T12:08:07.028
		LocalDateTime localDateTimeNow = LocalDate.now().atTime(LocalTime.now());
		System.out.println(localDateTimeNow);
	}
}