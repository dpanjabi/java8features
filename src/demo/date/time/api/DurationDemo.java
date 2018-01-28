package demo.date.time.api;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class DurationDemo {
	public static void main(String[] args) {
		// 2011-01-13 01:13
		Instant firstInstant= Instant.ofEpochSecond(1294881180); 
		// 2011-01-11 01:11
		Instant secondInstant = Instant.ofEpochSecond(1294708260);
		// negative because firstInstant is after secondInstant (-172920)
		Duration between = Duration.between(firstInstant, secondInstant);
		System.out.println(between.getSeconds());
		System.out.println(between.abs().toMinutes());
		System.out.println(Duration.ofHours(2).getSeconds());
		System.out.println(ChronoUnit.SECONDS.between(firstInstant , secondInstant));
	}
}