package shapes;

public abstract class Shape {
	protected String name;
	protected float area;
	
	public Shape(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public float calculateArea() {
		return this.area;
	}
}
