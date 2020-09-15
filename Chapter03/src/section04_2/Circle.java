package section04_2;

public class Circle extends Shape{

	public int radius;
	
	public Circle(int radius) {
		this.radius = radius;
	}

	@Override
	public double computeArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double computePerimeter() {
		return 2.0 * Math.PI * radius;
	}

	
}
