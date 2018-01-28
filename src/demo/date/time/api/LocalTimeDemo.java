package demo.date.time.api;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class LocalTimeDemo {
	public static void main(String[] args) {
		// Current LocalTime e.g. 14:51:28.796
		System.out.println(LocalTime.now());

		// 23:59:59.999999999
		System.out.println(LocalTime.MAX);

		// 00:00
		System.out.println(LocalTime.MIN);

		// 00:00
		System.out.println(LocalTime.MIDNIGHT);

		// 12:00
		System.out.println(LocalTime.NOON);

		// 10:12:48.000000956
		System.out.println(LocalTime.of(10, 12, 48, 956));
		
		// 10:24:12
		System.out.println(LocalTime.parse("10:24:12"));

		// 07:30
		System.out.println(LocalTime.of(6, 30).plusHours(25));

		// 08:15:03
		System.out.println(LocalTime.of(8, 25, 3).minusMinutes(10));

		// 03:30:25
		System.out.println(LocalTime.of(3, 30, 35).minus(10, ChronoUnit.SECONDS));

		LocalTime localTime = LocalTime.of(11, 35, 40);
		// 11
		System.out.println(localTime.getHour());

		// 35
		System.out.println(localTime.getMinute());

		// 40
		System.out.println(localTime.getSecond());

		// 0
		System.out.println(localTime.getNano());

		// 41740
		System.out.println(localTime.toSecondOfDay());

		// 41740000000000
		System.out.println(localTime.toNanoOfDay());

		// true
		System.out.println(localTime.isAfter(LocalTime.MIN));

		// true
		System.out.println(localTime.isBefore(LocalTime.MAX));
	}
}