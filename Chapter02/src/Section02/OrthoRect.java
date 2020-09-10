package Section02;

public class OrthoRect {

	public OrthoLine2 leftVertical;
	public OrthoLine2 rightVertical;
	public OrthoLine2 upHorizontal;
	public OrthoLine2 downHorizontal;
	
	public OrthoLine2 getMinShortHori() {
		if(upHorizontal.v.x < downHorizontal.v.x) {
			return upHorizontal;
		} else {
			return downHorizontal;
		}
	}
	
	public MyPoint2 getLeftUpXY() {
		return new MyPoint2(leftVertical.u.x, upHorizontal.u.y);
	}
	
	public MyPoint2 getRightDownXY() {
		return new MyPoint2(rightVertical.u.x, downHorizontal.u.y);
	}
	
	public int getArea() {
		MyPoint2 leftUp = getLeftUpXY();
		MyPoint2 rightDown = getRightDownXY();
		
		int area = (rightDown.x - leftUp.x) * (rightDown.y - leftUp.y);
		
		return area;
	}
	
	public boolean isInRect(OrthoLine2[] allLine) {
		boolean result = false;
		
		for (int i = 0; i < allLine.length; i++) {
			if(getLeftUpXY().x < allLine[i].u.x && getRightDownXY().x > allLine[i].u.x
					&& getLeftUpXY().y < allLine[i].u.y && getRightDownXY().y > allLine[i].u.y) {
				result = true;
			} else if(getLeftUpXY().x < allLine[i].v.x && getRightDownXY().x > allLine[i].v.x
					&& getLeftUpXY().y < allLine[i].v.y && getRightDownXY().y > allLine[i].v.y){
				result = true;
			}
		}
		
		return result;
	}
	
}
