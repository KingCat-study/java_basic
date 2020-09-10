package Section02;

public class OrthoLine2 {

	public MyPoint2 u;
	public MyPoint2 v;
	
	public OrthoLine2(MyPoint2 u,MyPoint2 v) {
		this.u = u;
		this.v = v;
		
		if(u.x > v.x || u.x == v.x && u.y > v.y) {
			swap();
		}
	}
	
	public OrthoLine2(int x1, int y1, int x2, int y2) {
		this.u = new MyPoint2(x1, y1);
		this.v = new MyPoint2(x2, y2);
		
		if(u.x > v.x || u.x == v.x && u.y > v.y) {
			swap();
		}
	}
	
	private void swap() {
		MyPoint2 tmp = u;
		u = v;
		v = tmp;
	}
	
	public boolean isVerical() {
		return u.x == v.x;
	}
}
