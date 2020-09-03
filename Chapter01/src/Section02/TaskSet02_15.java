package Section02;

import java.util.Scanner;

/*
서로 다른 수들로 구성된 수열 a1, a2,…, an이 있다. 어떤 수가 자신과 인접한 두 수 (즉, 바로 전의 수와 바로 다음
의 수)보다 작을 때 그 수를 local mimimum이라고 부른다. 단 a1의 경우에는 a2보다 작으면, an의 경우에는 an-1
보다 작으면 local mimimum이다. 어떤 수열에서 local minimum이 최대 1개일 때 그 수열은 “오목하다”라고
부르기로 하자. 입력으로 하나의 수열이 주어질 때 가장 길이가 긴 오목한 부분 수열을 찾아서 출력하는 프로그램
을 작성하라. 예를 들어 입력 수열이 1, 3, 7, 6, 12, 11, 9, 0, -1, 2, -3, 5 라면 가장 긴 오목한 부분 수열
은 12, 11, 9, 0, -1, 2이다. 입력 형식은 먼저 n의 값이 주어지고 이어서 n개의 정수가 주어진다.
*/

public class TaskSet02_15 {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		
		int [] data = new int[n];
		
		for (int i = 0; i < data.length; i++) {
			data[i] = kb.nextInt();
		}
		
		kb.close();
		
//		int [] data = {1, 3, 7, 6, 12, 11, 9, 0, -1, 2, -3, 5};
		
		int downCntMax = 0;
		int downCntLastIndex = 0;
		
		int upCntMax = 0;
		int upCntLastIndex = 0;
		
		for (int i = 0; i < data.length; i++) {
			
			int [] downCntData = downCnt(i ,data);
			
			int [] upCntData = new int[2];
			
			if(downCntData[1] > downCntMax) {
				downCntMax = downCntData[1];
				downCntLastIndex = downCntData[0];
				
				upCntData = upCnt(downCntLastIndex ,data);
				
				upCntMax = upCntData[1];
				upCntLastIndex = upCntData[0];
				
			} else if(downCntData[1] != 0 && downCntData[1] == downCntMax) {
				upCntData = upCnt(downCntData[0] ,data);
				
				if(upCntData[1] > upCntMax) {
					upCntMax = upCntData[1];
					upCntLastIndex = upCntData[0];
				}
			}
		}
		
		int startIndex = downCntLastIndex - (downCntMax -1);
		
		printLocalMinimumRange(data,startIndex, upCntLastIndex);
	}
	
	public static int[] downCnt(int index, int [] data) {
		int [] result = new int [2];
		
		int innerCnt = 0;
		int innerIdx = 0;
		
		for (int i = index; i < data.length-1; i++) {
			if(data[i] > data[i+1]) {
				innerCnt++;
			} else if(data[i] < data[i+1]) {
				innerCnt++;
				innerIdx = i;
				break;
			}
		}
		
		result[0] = innerIdx;
		result[1] = innerCnt;
		
		return result;
	}
	
	public static int[] upCnt(int index, int [] data) {
		int [] result = new int [2];
		
		int innerCnt = 0;
		int innerIdx = 0;
		
		for (int i = index; i < data.length-1; i++) {
			if(data[i] < data[i+1]) {
				innerCnt++;
			} else if(data[i] > data[i+1]) {
				innerCnt++;
				innerIdx = i;
				break;
			}
		}
		
		result[0] = innerIdx;
		result[1] = innerCnt;
		
		return result;
	}
	
	public static void printLocalMinimumRange(int[] data, int startIndex, int endIndex) {
		
		for (int i = startIndex; i <= endIndex; i++) {
			System.out.print(data[i] + " ");
		}
	}
}
