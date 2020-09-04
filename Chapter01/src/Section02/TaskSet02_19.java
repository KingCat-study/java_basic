package Section02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
입력파일 input19.txt에 먼저 정수의 개수 n과 이어서 n개의 정수가 주어진다. 이 정수들을 입력된 순서대로 아
래의 왼쪽 그림과 같이 n*n 그리드의 대각선에 저장한다. 아래의 그림은 n=4이고 입력 정수가 6, 1, 5, 3인 경우
의 예이다. 이제 그리드의 대각선 위쪽의 칸들을 모두 채운다. 규칙은 grid[i][j]에는 grid[i+1][j] - grid[i][j-1]
의 절대값을 저장한다. 즉 자신의 “바로 왼쪽 값과 바로 아래쪽 값의 차이의 절대값”이다. 이런 식으로 대각선 위
쪽의 모든 칸을 채우고, 대각선의 아래쪽은 그냥 0으로 채워서 화면으로 출력하는 프로그램을 작성하라. 
*/
public class TaskSet02_19 {

	public static void main(String[] args) {
		
		try {
			Scanner inputFile = new Scanner(new File("input_taskSet02_19.txt"));
			
			int n = inputFile.nextInt();
			System.out.println(n);
			
			int [][] grid = new int[n][n];
			
			for (int i = 0; i < grid.length; i++) {
				grid[i][i] = inputFile.nextInt();
			}
			
			inputFile.close();
			
			for (int i = 1; i < grid.length; i++) {
				setGrid(i, grid);
			}
			
			for (int i = 0; i < grid.length; i++) {
				for (int k = 0; k < grid.length; k++) {
					System.out.print(grid[i][k] + " ");
				}
				System.out.println();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		}
	}
	
	public static void setGrid(int cnt, int [][] grid) {
		for (int i = 0; i < grid.length-cnt; i++) {
			int j = i+cnt;
			
			int tmp = grid[i+1][j] - grid[i][j-1];
			
			grid[i][j] = getAbs(tmp);
		}
	}
	
	public static int getAbs(int a) {
		if(a < 0) {
			a = a * -1;
			return a;
		} else {
			return a;
		}
	}
}
