package Section02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code21 {

	static int [][] grid;

	static int [] coordX = {0,1,1,1,0,-1,-1,-1};
	static int [] coordY = {-1,-1,0,1,1,1,0,-1};
	
	public static void main(String[] args) {
		
		try {
			Scanner dataFile = new Scanner(new File("data.txt"));
			
			int n = dataFile.nextInt();
			
			grid = new int[n][n];
			
			for (int i = 0; i < n; i++)	{
				for (int j = 0; j < n; j++) {
					grid[i][j] = dataFile.nextInt();
				}
			}
			
			dataFile.close();
			
			for (int x = 0; x < grid.length; x++) {
				for (int y = 0; y < grid.length; y++) {
					for (int dir = 0; dir < 8; dir++) {
						for (int len = 1; len <= grid.length; len++) {
							int getVal = computeVal(x,y,dir,len);
							if(isPrime(getVal) && getVal != -1 && getVal != 0) {
								System.out.println(getVal);
							}
						}
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public static int computeVal(int x, int y, int dir, int len) {
		
		int val = 0;
		
		for (int i = 0; i < len; i++) {
			int digit = getDigit(x,y,dir,i);
			if(digit == -1) {
				return -1;
			}
			val = val * 10 + digit;
		}
		
		return val;
	}
	
	//2차원 배열표에서 좌표,방향,이동할 거리를 받아서 해당 좌표의 값의 유효여부를 판단 후 유효 하다면 좌표에 해당하는 값을 돌려주고
	//무효 하다면 -1 반환
	public static int getDigit(int x, int y, int dir, int len) {
		
		int newX = x + (coordX[dir] * len);
		int newY = y + (coordY[dir] * len);
		
		//방향의 경우의 수는 총 8가지
		// x 만 움직이는 방향 : 2,6
		// y 만 움직이는 방향 : 0,4
		// 방향 별 좌표 움직임
		// 0 = x - 0 , y - 1
		// 1 = x + 1 , y - 1
		// 2 = x + 1 , y + 0
		// 3 = x + 1 , y + 1
		// 4 = x + 0 , y + 1
		// 5 = x - 1 , y + 1
		// 6 = x - 1 , y - 0
		// 7 = x - 1 , y - 1
		// 필요한 것 방향 별 x,y 의 변화 값
		// 현재 좌표 x = 0, y = 1
		// 방향이 0 , 이동할 거리가 1
		// newX = x + (거리 * 방향에 따른 값) , newY = y + (거리 * 방향에 따른 값)
		// newX나 newY 가 0보다 작거나 배열 최대 크기보다 크다면 무효한 값
		
		if(newX < 0 || newX >= 4 || newY < 0 || newY >= 4) {
			return -1;
		} else {
			return grid[newX][newY];
		}
	}
	
	public static boolean isPrime(int checkVal) {
		
		boolean result = true;
		
		for (int i = 2; i*i <= checkVal; i++) {
			if(checkVal % i == 0)
			{
				return false;
			}
		}
		
		return result;
	}
}
