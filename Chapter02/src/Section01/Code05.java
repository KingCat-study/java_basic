package Section01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code05 {

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
				n++;
			}
			
			rectFile.close();
			
			bubbleSort();
			
			for (int i = 0; i < n; i++) {
				System.out.println(myRects[i].leftUpper.x + " " + myRects[i].leftUpper.y + " "
						+ myRects[i].width + " " + myRects[i].height);
			}
			
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
}
