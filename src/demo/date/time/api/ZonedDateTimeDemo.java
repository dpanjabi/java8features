package demo.date.time.api;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeDemo {
	public static void main(String[] args) {
		// [Asia/Aden, America/Cuiaba,…
		System.out.println(ZoneId.getAvailableZoneIds());

		System.out.println(ZonedDateTime.now());

		LocalDateTime dateTime = LocalDateTime.of(2014, 02, 20, 12, 0);

		// 2014-02-20T12:00
		System.out.println(dateTime);

		// Europe/Berlin
		ZoneId berlin = ZoneId.of("Europe/Berlin");
		System.out.println(berlin);

		// 2014-02-20T12:00+01:00[Europe/Berlin]
		ZonedDateTime berlinDateTime = ZonedDateTime.of(dateTime, berlin);	
		System.out.println(berlinDateTime);

		// America/Los_Angeles
		ZoneId losAngeles = ZoneId.of("America/Los_Angeles");
		System.out.println(losAngeles);

		// 2014-02-20T03:00-08:00[America/Los_Angeles]
		ZonedDateTime losAngelesDateTime = berlinDateTime.withZoneSameInstant(losAngeles);
		System.out.println(losAngelesDateTime);

		// -28800
		System.out.println(losAngelesDateTime.getOffset().getTotalSeconds()); 

		// 2015-05-03T10:15:30+02:00[Europe/Paris]
		ZonedDateTime.parse("2015-05-03T10:15:30+01:00[Europe/Paris]");
	}
}