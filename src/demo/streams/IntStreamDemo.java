package demo.streams;

import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class IntStreamDemo {
	public static void main(String[] args) {
		rangeDemo();

		generateDemo();

		iterateDemo();

		builderAndAnyMatchDemo();

		streamConcatenationAndAllMatchDemo();

		rangeClosedAndCountDemo();

		ofAndAverageDemo();

		ofAndSumDemo();

		longStreamConversionDemo();

		doubleStreamConversionDemo();

		boxedStreamConversionDemo();

		objectStreamConversionDemo();
	}

	private static void objectStreamConversionDemo() {
		// Map IntStream to other object stream demo
		Stream<Cube> mapIntStreamToCubeStream = IntStream.range(1, 5).mapToObj(new IntFunction<Cube>() {
			@Override
			public Cube apply(int value) {
				return new Cube(value);
			}
		});
		mapIntStreamToCubeStream.forEach(new Consumer<Cube>() {

			@Override
			public void accept(Cube cube) {
				System.out.println(cube);
			}			
		});
	}

	private static void boxedStreamConversionDemo() {
		@SuppressWarnings("unused")
		Stream<Integer> integerStream = IntStream.rangeClosed(1, 5).boxed();
	}

	private static void doubleStreamConversionDemo() {
		@SuppressWarnings("unused")
		DoubleStream doubleStream = IntStream.rangeClosed(1, 5).asDoubleStream();
	}

	private static void longStreamConversionDemo() {
		// Convert IntStream to LongStream
		@SuppressWarnings("unused")
		LongStream longStream = IntStream.rangeClosed(1, 10).asLongStream();
	}

	private static void ofAndSumDemo() {
		// Sum Demo
		System.out.println(IntStream.of(1, 2, 3, 4).sum());
	}

	private static void ofAndAverageDemo() {
		// of() Demo and Average Demo
		OptionalDouble average = IntStream.of(1, 2, 3, 4).average();
		System.out.println(average.getAsDouble());
	}

	private static void rangeClosedAndCountDemo() {
		// Range Closed and Count Demo
		System.out.println(IntStream.rangeClosed(1, 5).count());
	}

	private static void streamConcatenationAndAllMatchDemo() {
		// Streams concatenation and allMatch() demo 
		IntStream concatinated = IntStream.concat(IntStream.of(2), IntStream.of(3));
		boolean allMatch = concatinated.allMatch(new IntPredicate() {

			@Override
			public boolean test(int value) {
				int[] primes = {2, 3, 5, 7};
				for(int prime: primes) {
					if(value == prime) {
						return true;
					}
				}
				return false;
			}
		});
		System.out.println(allMatch);
	}

	private static void builderAndAnyMatchDemo() {
		// Builder and anyMatch() demo
		boolean anyMatch = IntStream.builder().add(1).add(2).add(3).build().anyMatch(new IntPredicate() {

			@Override
			public boolean test(int value) {
				return value%2 == 0;
			}
		});
		System.out.println(anyMatch);
	}

	private static void iterateDemo() {
		// Iterate Demo
		IntStream.iterate(10, new IntUnaryOperator() {
			@Override
			public int applyAsInt(int operand) {
				return operand + 1;
			}
		})
		.limit(10)
		.filter(new IntPredicate() {

			@Override
			public boolean test(int value) {
				return value%2 == 0;
			}
		})
		.forEach(new IntConsumer() {
			@Override
			public void accept(int value) {
				System.out.println(value);
			}
		});
	}

	private static void generateDemo() {
		// Generate Demo
		// Fibonacci series logic
		int fib[] = {0, 1, -1};
		IntStream.generate(new IntSupplier() {
			@Override
			public int getAsInt() {
				int gen = fib[0];
				fib[2] = fib[0] + fib[1];
				fib[0] = fib[1];
				fib[1] = fib[2];
				return gen;
			}
		})
		.limit(10)
		.forEach(new IntConsumer() {
			@Override
			public void accept(int value) {
				System.out.println(value);
			}
		});
	}

	private static void rangeDemo() {
		// RangeDemo
		IntStream.range(1, 10)
		.forEach(new IntConsumer() {
			@Override
			public void accept(int value) {
				System.out.println(value);
			}
		});
	}

	static class Cube {
		int size;
		Cube(int s) {
			size = s;
		}
		@Override
		public String toString() {
			return "Cube of l, w, h: " + size;
		}
	}
}