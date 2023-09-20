package shapes;

public class Square extends Shape {
	private Integer sideLength;

	public Square(String name, Integer sideLength) {
		super(name);
		this.sideLength = sideLength;
	}

	public float calculateArea() {
		this.area = sideLength * sideLength;
		return this.area;
	}
}
