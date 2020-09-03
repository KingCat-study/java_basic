package Section02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
Code21.java의 문제에서 대각방향은 제외하고 가로, 세로로만 인접한 수로 구성되는
모든 소수를 찾아 출력하는 프로그램을 작성하라. 단, 각 행이나 열의 끝과 시작이
연결되어 있어서 원형이라고 가정한다. 가령 옆의 그림에서 511도 찾아야 한다. 입력은
input18.txt 파일에서 받아들이고 입력 파일의 첫 줄에 그리드의 크기 n이 주어진다.
*/

public class TaskSet02_18 {

	public static void main(String[] args) {
		
		try {
			
			Scanner inputFile = new Scanner(new File("input_taskSet02_18.txt"));
			
			int n = inputFile.nextInt();
			
			int [][] data = new int[n][n];
			
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data.length; j++) {
					data[i][j] = inputFile.nextInt();
				}
			}
			
			inputFile.close();
			
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data.length; j++) {
					
					int val = data[i][j];
					
					if(isPrime(val)) {
						System.out.println(val);
					}
					
					int [] leftIndex = leftSearch(j, data.length);
					
					for (int k = 0; k < leftIndex.length; k++) {
						val = val * 10 + data[i][leftIndex[k]];
						
						if(isPrime(val)) {
							System.out.println(val);
						}
					}
					
					val = data[i][j];
					
					int [] rightIndex = rightSearch(j, data.length);
					
					for (int l = 0; l < rightIndex.length; l++) {
						val = val * 10 + data[i][rightIndex[l]];
						
						if(isPrime(val)) {
							System.out.println(val);
						}
					}
					
					val = data[j][i];
					
					if(isPrime(val)) {
						System.out.println(val);
					}
					
					for (int p = 0; p < leftIndex.length; p++) {
						val = val * 10 + data[leftIndex[p]][i];
						
						if(isPrime(val)) {
							System.out.println(val);
						}
					}
					
					val = data[j][i];
					
					for (int l = 0; l < rightIndex.length; l++) {
						val = val * 10 + data[rightIndex[l]][i];
						if(isPrime(val)) {
							System.out.println(val);
						}
					}
					
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		}
		
//		int [][] data = {{6, 6, 3, 1},
//						 {1, 1, 0, 5},
//						 {1, 6, 5, 4},
//						 {5, 0, 7, 3}};
		
		

	}

	public static int[] leftSearch(int idx , int len) {
		
		int [] returnData = new int[len-1];
		
		int i = idx;
		
		int cur = i - 1;
		
		if(cur < 0) {
			cur = len-1;
		}
		
		for (int j = 0; j < len-1; j++) {
//			System.out.print(cur + " ");
			
			returnData[j] = cur;
			
			cur = cur - 1;
			
			if(cur < 0) {
				cur = len-1;
			}
		}
		
		return returnData;
	}
	
	public static int[] rightSearch(int idx, int len) {
		
		int [] returnData = new int[len-1];
		
		int i = idx;
		
		int cur = i + 1;
		
		if(cur >= len) {
			cur = 0;
		}
		
		for (int j = 0; j < len-1; j++) {
//			System.out.print(cur + " ");
			returnData[j] = cur;
			
			cur = cur + 1;
			
			if(cur >= len) {
				cur = 0;
			}
		}
		
		return returnData;
	}
	
	public static boolean isPrime(int a) {
		boolean result = true;
		
		if(a < 2) {
			result = false;
		} else {
			for (int i = 2; i*i < a; i++) {
				if(a % i == 0) {
					return false;
				}
			}
		}
		
		return result;
	}
}
