package Section02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code09 {

	static MyRectangle2 [] myRects = new MyRectangle2[1000];
	static int n = 0;
	
	public static void main(String[] args) {
		
		try {
			Scanner rectFile = new Scanner(new File("rectangle.txt"));
			
			while(rectFile.hasNext()) {
				myRects[n] = new MyRectangle2(rectFile.nextInt(),rectFile.nextInt(),rectFile.nextInt(),rectFile.nextInt());
				n++;
			}
			
			rectFile.close();
			
			bubbleSort();
			
			for (int i = 0; i < n; i++) {
				System.out.println(myRects[i].toString());
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		}
	}
	
	public static void bubbleSort() {
		for (int i = n-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if(myRects[j].calArea() > myRects[j+1].calArea()) {
					MyRectangle2 tmp = myRects[j]; 
					myRects[j] = myRects[j+1];
					myRects[j+1] = tmp;
				}
			}
		}
	}
}
