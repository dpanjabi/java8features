package demo.date.time.api;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class OffsetDateTimeDemo {
	public static void main(String[] args) {
		/** Current date time with an offset */
		// 2018-01-22T03:12:05.609-06:00
		System.out.println(OffsetDateTime.now());

		/** Current date time from specified time-zone with an offset */
		// 2018-01-22T03:12:05.780-06:00
		System.out.println(OffsetDateTime.now(ZoneId.systemDefault()));

		// +05:00
		ZoneOffset offset = ZoneOffset.of("+05:00");
		System.out.println(offset);

		// 2013-07-20T03:30
		LocalDateTime date = LocalDateTime.of(2013, Month.JULY, 20, 3, 30);
		System.out.println(date);

		// 2013-07-20T03:30+05:00
		OffsetDateTime plusFive = OffsetDateTime.of(date, offset);
		System.out.println(plusFive);

		// -02:00
		ZoneOffset offsetOf2Hours = ZoneOffset.ofHours(-2);
		System.out.println(offsetOf2Hours);

		// 2013-07-19T20:30-02:00
		OffsetDateTime minusTwo = plusFive.withOffsetSameInstant(offsetOf2Hours);
		System.out.println(minusTwo);

		// 2012-12-25T12:00
		LocalDateTime localDateTime = LocalDateTime.of(2012,12,25,12,0);
		System.out.println(localDateTime);

		// 2012-12-25T12:00-02:00
		OffsetDateTime offsetDateTime = localDateTime.atOffset(offsetOf2Hours);
		System.out.println(offsetDateTime);
	}
}