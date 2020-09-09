package Section01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
Code05.java에서 처럼 평면상의 n개의 사각형을 입력 파일로 부터 입력받 후, 서로 교차하는 사각형쌍들 중 그
교집합의 면적이 최대인 쌍을 찾아서 그 면적을 출력하는 프로그램을 작성하라.
*/
public class TaskSet01_02 {

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
			
			findMaxUnion();
			
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
	
	public static void findMaxUnion() {
		int max = 0;
		for (int i = 0; i < n-1; i++) {
			int unionCnt = unionCount(myRects[i],myRects[i+1]);
			if(max < unionCnt) {
				max = unionCnt;
			}
		}
		
		System.out.println(max);
	}
	
	public static int unionCount(MyRectangle1 first, MyRectangle1 second) {
		int count = 0;
		for (int i = first.leftUpper.x; i <= first.sideX; i++) {
			for (int j = first.leftUpper.y; j <= first.sideY; j++) {
				if(second.leftUpper.x <= i && i <= second.sideX && second.leftUpper.y <= j && j  <= second.sideY) {
					count++;
				}
			}
		}
		
		return count;
	}
	
}
