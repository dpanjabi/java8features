package demo.date.time.api;

import java.time.Instant;

public class InstantDemo {
	public static void main(String[] args) {
		// Current time - 2018-01-22T09:16:28.742Z
		System.out.println(Instant.now());

		// 1970-01-01T00:00:00Z
		System.out.println(Instant.EPOCH);

		// +1000000000-12-31T23:59:59.999999999Z
		System.out.println(Instant.MAX);

		// -1000000000-01-01T00:00:00Z
		System.out.println(Instant.MIN);

		// 2010-01-01T12:00:00Z
		Instant from19700101 = Instant.ofEpochSecond(1262347200);
		System.out.println(from19700101);

		// 2010-01-01T12:00:00Z
		Instant fromEpochMilli = Instant.ofEpochMilli(1262347200000l);
		System.out.println(fromEpochMilli);

		// 1969-12-31T23:59:51Z
		System.out.println(Instant.ofEpochSecond(-9));

		// 2010-01-01T12:00:00Z
		System.out.println(Instant.parse("2010-01-01T12:00:00Z"));

		// toString() returns ISO 8601 format, e.g. 2018-01-22T09:16:28.742Z
		System.out.println(from19700101.toString());

		// 1262347200
		System.out.println(from19700101.getEpochSecond());

		// 1262347200000
		System.out.println(from19700101.toEpochMilli());

		// 2010-01-01T12:00:10.100Z
		System.out.println(from19700101.plusMillis(100).plusSeconds(10));
	}
}