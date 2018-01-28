package demo.streams;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomStreamDemo {
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
				new Person("Max", 18), 
				new Person("Peter", 23), 
				new Person("Pamela", 23), 
				new Person("David", 12));

		List<Person> filtered = persons
				.stream()
				.filter(p -> p.name.startsWith("P"))
				.collect(Collectors.toList());
		// [Peter, Pamela]
		System.out.println(filtered);

		Map<String, Integer> filteredMap = persons
				.stream()
				.filter(((Predicate<Person>)p->p.getAge() > 18).negate())
				.collect(Collectors.toMap(Person::getName, Person::getAge));
		// {Max=18, David=12}
		System.out.println(filteredMap);

		String joinResult = persons.stream().map(Person::getName).collect(Collectors.joining());
		// MaxPeterPamelaDavid
		System.out.println(joinResult);

		String spaceSeparatedResult = persons.stream().map(Person::getName).collect(Collectors.joining(" "));
		// Max Peter Pamela David
		System.out.println(spaceSeparatedResult);

		String withPrefixAndPostFix = persons.stream().map(Person::getName).collect(Collectors.joining(",", "[", "]"));
		// [Max,Peter,Pamela,David]
		System.out.println(withPrefixAndPostFix);

		Long count = persons.stream().collect(Collectors.counting());
		// 4
		System.out.println(count);    

		Double average = persons.stream().collect(Collectors.averagingDouble(Person::getAge));
		// 19.0
		System.out.println(average);

		Integer sum = persons.stream().collect(Collectors.summingInt(Person::getAge));
		// 76
		System.out.println(sum);    

		DoubleSummaryStatistics statisticsResult = persons.stream().collect(Collectors.summarizingDouble(Person::getAge));
		// DoubleSummaryStatistics{count=4, sum=76.000000, min=12.000000, average=19.000000, max=23.000000}
		System.out.println(statisticsResult);
		
		Map<Integer, List<Person>> groupedByAge = persons.stream().collect(Collectors.groupingBy(p -> p.age));
		// age 18: [Max]
		// age 23: [Peter, Pamela]
		// age 12: [David]
		groupedByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
		
		Map<Boolean, List<Person>> partitionByName = persons.stream().collect(Collectors.partitioningBy(p -> p.getAge() > 18));    
		System.out.println(partitionByName); // {false=[Max, David], true=[Peter, Pamela]}
	}
	
	private static class Person {
	    String name;
	    int age;

	    Person(String name, int age) { 
		this.name = name; 
		this.age = age; 
	    }

	    public String getName() {
		return name;
	    }

	    public int getAge() {
		return age;
	    }

	    @Override
	    public String toString() { return name; }
	}
}