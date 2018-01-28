package demo.date.time.api;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class LegacyClassConversionDemo {
	public static void main(String[] args) {

		// 2018-01-28T11:07:44.232Z
		Instant instantFromDate = new Date().toInstant();
		System.out.println(instantFromDate);

		// 2018-01-28T11:07:44.645Z
		Instant instantFromCalendar = Calendar.getInstance().toInstant();
		System.out.println(instantFromCalendar);

		long secondsPerDay = 24 * 3600;

		// 2018-01-28
		LocalDate localDateFromInstant = LocalDate.ofEpochDay(instantFromDate.getEpochSecond() / secondsPerDay);
		System.out.println(localDateFromInstant);

		// 11:07:44
		LocalTime longTimeFromInstant = LocalTime.ofSecondOfDay(instantFromCalendar.getEpochSecond() % secondsPerDay);
		System.out.println(longTimeFromInstant);

		// 2018-01-28T16:37:44.232
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instantFromDate, ZoneId.systemDefault());
		System.out.println(localDateTime);

		// 2018-01-28T16:37:44.232+05:30
		OffsetDateTime offsetDateTimeFromInstant = instantFromDate.atOffset(ZoneOffset.ofHoursMinutes(5,30));
		System.out.println(offsetDateTimeFromInstant);

		// 2018-01-28T16:37:44.645+05:30[Asia/Calcutta]
		ZonedDateTime zonedDateTimeFromInstant = instantFromCalendar.atZone(ZoneId.systemDefault());
		System.out.println(zonedDateTimeFromInstant);
	}
}