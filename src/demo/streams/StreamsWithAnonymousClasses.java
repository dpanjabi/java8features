package demo.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamsWithAnonymousClasses {
	public static void main(String[] args) {
		Arrays.asList("a1", "a2", "a2", "c5", "c4", "c3", "b1", "c2", "c1")
		.stream() // Creates sequential stream
		.filter(new Predicate<String>() {
			public boolean test(String s) {
				System.out.println("filter() for " + s);
				return s.startsWith("c");
			}
		})
		.map(new Function<String, String>() {
			public String apply(String s) {
				System.out.println("map() for " + s);
				return s.toUpperCase();
			}
		})
		.limit(3)
		.sorted(new Comparator<String>() {
			public int compare(String s1, String s2) {
				System.out.println("sorting() for "+s1+" & "+s2);
				return s1.compareTo(s2);
			}
		})
		.forEach(new Consumer<String>() {
			public void accept(String s) {
				System.out.println("forEach: " + s);
			}
		});
	}
}