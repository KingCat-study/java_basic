package Section02;

import java.util.Scanner;

/*
아래 그림과 같이 0 혹은 1로 채워진 n*n 그리드가 주어진다. “1만으로 채워진” 가장 큰 정사각형을 찾아 그 면
적을 출력하는 프로그램을 작성하라. 입력 형식은 먼저 n의 값이 주어지고 이어서 n*n개의 0 혹은 1의 값이 한
칸씩 띄워져서 한 줄에 n개씩 주어진다.
*/
public class TaskSet02_17 {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		
		int [][] data = new int[n][n];
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				data[i][j] = kb.nextInt();
			}
		}
		
		kb.close();
//		int [][] data = {{0, 1, 1, 0, 0, 1},{1, 0, 1, 1, 1, 0},{0, 1, 1, 1, 1, 1},{1, 0, 1, 1, 1, 1 },{0, 1, 1, 0, 0, 0},{1, 1, 0, 1, 1, 1}};
		
		int maxCnt = 0;
		
		for (int i = 0; i < data.length-1; i++) {
			
			int count = 0;
			int startIdx = 0;
			int endIdx = 0;
			
			for (int j = 0; j < data.length; j++) {
				if(data[i][j] == 1) {
					int tmp = isOnePrint(data[i],j);
					if(tmp > count) {
						count = tmp;
						startIdx = j;
						endIdx = startIdx + tmp;
					}
				}
			}
			
			if(isSquare(data, startIdx, endIdx, i) && count > maxCnt) {
				maxCnt = count;
			}
		}
		
		System.out.println((maxCnt+1)*(maxCnt+1));
		
	}
	
	public static int isOnePrint(int [] data, int index) {

		int count = 0;
		for (int i = index; i < data.length-1; i++) {
			if(data[i] == 1 && data[i+1] == 1) {
				count++;
			} else if(data[i] == 1 && data[i+1] == 0) {
				break;
			}
		}
		
		return count;
	}
	
	public static boolean isSquare(int [][] data, int xStartIdx, int xEndIdx, int yStartIdx) {
		
		boolean result = true;
		int yEndIdx = xEndIdx - xStartIdx;
		
		int forMax = (yStartIdx+yEndIdx) > data.length-1 ? data.length-1 : yStartIdx+yEndIdx;
		
		for (int i = yStartIdx; i <= forMax; i++) {
			boolean isOne = true;
			for (int j = xStartIdx; j <= xEndIdx; j++) {
				if(data[i][j] != 1) {
					isOne = false;
				}
			}
			result = isOne;
		}
		
		return result;
	}

}
