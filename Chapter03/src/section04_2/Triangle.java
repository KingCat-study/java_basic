package section04_2;

public class Triangle extends Shape{
	public int width;
	public int height;
	
	public Triangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double computeArea() {
		return (double)(width * height) / 2;
	}

	@Override
	public double computePerimeter() {
		return Math.sqrt(Math.pow(width, 2)+Math.pow(height, 2))+width+height;
	};
}
