package demo.functional.interfaces;

import java.util.function.Function;

public class FunctionalInterfacesDemo {
	public static void main(String[] args) {
		Function<Integer, Cube> integerToCube = new Function<Integer, Cube>() {
			@Override
			public Cube apply(Integer size) {
				return new Cube(size);
			}
		};
		Function<Cube, ColoredCube> cubeToColoredCube = new Function<Cube, ColoredCube>() {
			
			@Override
			public ColoredCube apply(Cube cube) {
				return new ColoredCube(cube.size, "Red");
			}
		};
		Function<ColoredCube, Long> coloredCubeVolume = new Function<ColoredCube, Long>() {
			@Override
			public Long apply(ColoredCube coloredCube) {
				return coloredCube.volume();
			}
		};
		
		Long volume = cubeToColoredCube.compose(integerToCube).andThen(coloredCubeVolume).apply(5);
		System.out.println(volume);
	}
	
	static class Cube {
		protected int size;
		
		public Cube(int s) {
			this.size = s;
		}
		
		@Override
		public String toString() {
			return "Cube of l,w,h: " + size;
		}
	}
	
	static class ColoredCube extends Cube {
		protected String color;
		
		public ColoredCube(int size, String color) {
			super(size);
			this.color = color;
		}
		
		@Override
		public String toString() {
			return super.toString() + " and color: " + color;
		}
		
		public long volume() {
			long size = this.size;
			return size * size * size;
		}
	}
}