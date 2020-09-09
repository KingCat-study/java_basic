package Section02;

public class OrthoLine {
	//선분은 양 끝점에의해 결정 되므로
	public MyPoint2 u;
	public MyPoint2 v;
	
	public OrthoLine(MyPoint2 u, MyPoint2 v) {
		this.u = u;
		this.v = v;
		if(u.x > v.x || u.x == v.x && u.y > v.y) {
			swap();
		}
	}
	
	public OrthoLine(int x1, int y1, int x2, int y2) {
		this.u = new MyPoint2(x1, y1);
		this.v = new MyPoint2(x2, y2);
	}
	
	public void swap() {
		MyPoint2 tmp = u;
		u = v;
		v = tmp;
	}
	
	public boolean isVertical() {
		return u.x == v.x;
	}
	
	public boolean interects(OrthoLine other) {
		
		if(isVertical() && !other.isVertical()) {
			return (other.u.x < u.x && other.v.x > u.x && u.y < other.u.y && v.y > other.u.y);
		} else if(!isVertical() && other.isVertical()) {
			return (other.u.y < u.y && other.v.y > u.y && u.x < other.u.x && v.x > other.u.x);
		} else {
			return false;
		}
	}
}
