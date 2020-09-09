package Section02;

/*
좌표축에 평행한 하나의 사각형은 왼쪽-위쪽 꼭지점과 너비, 그
리고 높이에 의해서 정의된다
*/
public class MyRectangle2 {
	public MyPoint2 leftUpper;
	public int width;
	public int height;
	public int sideX;
	public int sideY;
	
	public MyRectangle2(int x, int y, int width, int height) {
		this.leftUpper = new MyPoint2(x, y);
		this.width = width;
		this.height = height;
		sideX = x + width;
		sideY = x + height;
	}
	
	public int calArea() {
		return width * height; 
	}

	@Override
	public String toString() {
		return "MyRectangle2 [leftUpper.x=" + leftUpper.x +", leftUpper.y=" + leftUpper.y +", width=" + width + ", height=" + height + "]";
	}
	
}
