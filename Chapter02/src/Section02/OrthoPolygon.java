package Section02;

public class OrthoPolygon {
	public int n;
	public MyPoint2 [] vertices;
	
	public OrthoPolygon(int n) {
		this.n = 0;
		vertices = new MyPoint2[n];
	}
	
	public void addVertex(int x , int y) {
		vertices[n++] = new MyPoint2(x,y);
	}

	public int maxX() {
		int max = vertices[0].x;
		for (int i = 0; i < n; i++) {
			if(vertices[i].x > max) {
				max = vertices[i].x;
			}
		}
		
		return max;
	}
	
	public boolean contains(MyPoint2 p) {
		OrthoLine arrow = new OrthoLine(p, new MyPoint2(maxX()+1, p.y));
		int count = 0;
		for (int i = 0; i < n; i++) {
			OrthoLine edge = new OrthoLine(vertices[i], vertices[(i+1) % n]);
			if(arrow.interects(edge)) {
				count++;
			}
		}
		//짝수면 도형안에 포함되어 있지 않고 홀 수면 도형안에 포함되었단 얘기이므로
		return (count % 2 == 1);
	}
}
