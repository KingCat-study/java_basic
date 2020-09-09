package Section02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
입력으로 하나의 직교 다각형(모든 변이 x-축 혹은 y-축과 평행한 다각형)과 또
하나의 점 p가 주어질 때 그 점이 다각형의 내부에 있는지 외부에 있는지 판단하는
프로그램을 작성하라.
입력 형식의 예: 시계방향으로 꼭지점의 좌표가 주어짐

겹치면 ? 문제를 조금 단순화하기 위해서
여기서는 점 p는 다각형의 경계상에 있지 않고, 또한 다각형에는 p와 동일
한 x혹은 y좌표를 가진 꼭지점은 없다고 가정한다.
(꼭지점의 좌표값은 모두 짝수, 검사할 점 p의 좌표값은 홀수로 가정한다.)

*/
public class Code10 {

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new File("data.txt"));
			
			int n = in.nextInt();
			OrthoPolygon thePolygon = new OrthoPolygon(n);
			
			for (int i = 0; i < n; i++) {
				thePolygon.addVertex(in.nextInt(), in.nextInt());
			}

			MyPoint2 p = new MyPoint2(in.nextInt(),in.nextInt());
			
			in.close();
			
			if(thePolygon.contains(p)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		}
	}

}
