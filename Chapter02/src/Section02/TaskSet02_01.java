package Section02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TaskSet02_01 {

	public static void main(String[] args) {
		
		try {
			Scanner in = new Scanner(new File("data_TaskSet02_01.txt"));
			
			int n = in.nextInt();
			OrthoLine2[] allLine = new OrthoLine2[n];
			
			int rectCnt = 0;
			OrthoRect[] rectList = new OrthoRect[n];
			
			for (int i = 0; i < n; i++) {
				allLine[i] = new OrthoLine2(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
			}
			
			in.close();
			
			for (int i = 0; i < allLine.length; i++) {
				if(allLine[i].isVerical()) {
					OrthoRect rect = new OrthoRect();
					int uMax = 0;
					int vMax = 0;
					for (int j = 0; j < allLine.length; j++) {
						
						if(!allLine[j].isVerical() && allLine[j].u.x < allLine[i].u.x && allLine[j].u.y > allLine[i].u.y && 
								allLine[i].v.x > allLine[j].v.x && allLine[i].v.y > allLine[j].v.y) {
							
							if(allLine[i].v.y - allLine[j].u.y > uMax) {
								uMax = allLine[i].v.y - allLine[j].u.y;
								// 수평 면 중 기준 u 에 가장 가까운 것
								rect.upHorizontal = allLine[j];
							}
							
							if(allLine[j].u.y - allLine[i].u.y > vMax) {
								vMax = allLine[j].u.y - allLine[i].u.y;
								//수평 면 중 기준 v 에 가장 가까운것
								rect.downHorizontal = allLine[j];
							}
						}
					}
					
					if(uMax != 0 && vMax != 0) {
						rect.leftVertical = allLine[i];
						OrthoLine2 shortHori = rect.getMinShortHori();
						int vHoriMax = 0;
						for (int j = 0; j < allLine.length; j++) {
							if(allLine[j].isVerical() && shortHori.v.x > allLine[j].v.x && shortHori.v.y > allLine[j].v.y) {
								if(allLine[j].v.x - rect.leftVertical.u.x > vHoriMax) {
									vHoriMax = allLine[j].v.x - rect.leftVertical.u.x;
									rect.rightVertical = allLine[j];
								}
							}
						}
						if(vHoriMax != 0) {
							rectList[rectCnt++] = rect;
						}
					}
				}
			}
			
			if(rectCnt == 0) {
				System.out.println(rectCnt);
			} else if( rectCnt > 0) {
				checkInRect(allLine,rectList);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void checkInRect(OrthoLine2[] allLine, OrthoRect[] rectList) {
		int rectCnt = 0;
		int maxArea = 0;
		for (int i = 0; i < rectList.length; i++) {
			if(!rectList[i].isInRect(allLine)) {
				if(rectList[i].getArea() > maxArea) {
					maxArea = rectList[i].getArea();
				}
			} else {
				rectCnt++;
			}
		}
		
		if(maxArea == 0 && rectCnt == rectList.length) {
			System.out.println(0);
		} else {
			System.out.println(maxArea);
		}
	}
}
