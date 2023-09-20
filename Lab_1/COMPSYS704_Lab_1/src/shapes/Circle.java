package shapes;

public class Circle extends Shape {
	private Integer radius;

	public Circle (String name, Integer radius) {
		super(name);
		this.radius = radius;
	}

	public float calculateArea() {
		this.area = (float)3.141592 * this.radius * this.radius;
		return this.area;
	}
}
