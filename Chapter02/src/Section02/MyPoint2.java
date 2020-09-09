package Section02;

/*
2차원 평면에서 정수 좌표를 가지는 하나의 점을 표현하기 위한
클래스. 한 점의 x-좌표와 y-좌표는 항상 붙어다녀야 하므로 하
나의 데이터 단위로 취급하기 위해서 이 클래스를 작성
*/
public class MyPoint2 {
	public int x;
	public int y;
	
	
	public MyPoint2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
