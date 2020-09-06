package Section01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
Code05.java에서 처럼 평면상의 n개의 직사각형을 입력 파일로 부터 읽은 후, 또 다른 한 점의 좌표를 키보드로
부터 입력 받아, 그 점을 포함하는 사각형의 개수를 출력하는 프로그램을 작성하라. 점이 사각형의 가장자리에 놓
일 때도 포함되는 것으로 간주한다.
*/
public class TaskSet01_01 {

	static MyRectangle1 [] myRects = new MyRectangle1[1000];
	static int n = 0;
	
	public static void main(String[] args) {
		
		try {
			Scanner rectFile = new Scanner(new File("rectangle.txt"));
			
			while(rectFile.hasNext()) {
				myRects[n] = new MyRectangle1();
				myRects[n].leftUpper = new MyPoint1();
				
				myRects[n].leftUpper.x = rectFile.nextInt();
				myRects[n].leftUpper.y = rectFile.nextInt();
				myRects[n].width = rectFile.nextInt();
				myRects[n].height = rectFile.nextInt();
				myRects[n].sideX = myRects[n].leftUpper.x + myRects[n].width;
				myRects[n].sideY = myRects[n].leftUpper.y + myRects[n].height;
				n++;
			}
			
			rectFile.close();
			
			bubbleSort();

			Scanner kb = new Scanner(System.in);
			
			int inputX = kb.nextInt();
			int inputY = kb.nextInt();
			
			findInRect(inputX,inputY);
			
			kb.close();
//			for (int i = 0; i < n; i++) {
//				System.out.println(myRects[i].leftUpper.x + " " + myRects[i].leftUpper.y + " "
//						+ myRects[i].width + " " + myRects[i].height);
//			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		}
	}
	
	public static void bubbleSort() {
		for (int i = n-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if(calArea(myRects[j]) > calArea(myRects[j+1])) {
					MyRectangle1 tmp = myRects[j]; 
					myRects[j] = myRects[j+1];
					myRects[j+1] = tmp;
				}
			}
		}
	}
	
	public static int calArea(MyRectangle1 r) {
		return r.width * r.height;
	}

	public static void findInRect(int x, int y) {
		for (int i = 0; i < n; i++) {
			if(x >= myRects[i].leftUpper.x && x <= myRects[i].sideX && y >= myRects[i].leftUpper.y && y <= myRects[i].sideY) {
				System.out.println(myRects[i].leftUpper.x + " " + myRects[i].leftUpper.y + " "
						+ myRects[i].width + " " + myRects[i].height);
			}
		}
	}
	
	
}
