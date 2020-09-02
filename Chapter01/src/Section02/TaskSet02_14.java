package Section02;

import java.util.Scanner;

/*
입력으로 정수의 개수 n과 이어서 n개의 정수들이 주어진다. 이 중 오름차순 혹은 내림차순으로 정렬되어 있는
가장 긴 구간을 찾아서 그 구간의 길이를 출력하는 프로그램을 작성하라. 예를 들어 n=13이고 입력 정수들이 2,
3, 15, 15, 13, 12, 11, 9, 0, -1, 2, -3, 5 라면 밑줄친 구간이 가장 긴 구간이고 그 길이는 8이다.
*/
public class TaskSet02_14 {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		
		int [] data = new int[n];
		
		int maxAscCnt = 0;
		int maxDescCtn = 0;
		int ascCnt = 1;
		int descCnt = 1;
		
//		int [] data = {2, 2, 2, 2, 2, 2, 2, 2, 15, 15, 16, 17};
//		int [] data = {2, 3, 15, 15, 13, 12, 11, 9, 0, -1, 2, -3, 5};
		
		for (int i = 0; i < data.length; i++) {
			data[i] = kb.nextInt();
		}
		
		kb.close();
		
		for (int i = 0; i < data.length-1; i++) {
			if(data[i] < data[i+1]) {
				
				ascCnt = ascCnt + 1;
				
				maxAscCnt = max(ascCnt, maxAscCnt);
				descCnt = 1;
				
			} else if(data[i] > data[i+1]) {
				
				descCnt = descCnt + 1;
				
				maxDescCtn = max(descCnt, maxDescCtn);
				ascCnt = 1;
				
			} else {
				ascCnt = ascCnt + 1;
				descCnt = descCnt + 1;
				
				maxAscCnt = max(ascCnt, maxAscCnt);
				maxDescCtn = max(descCnt, maxDescCtn);
			}
		}
		
		System.out.println(max(maxAscCnt, maxDescCtn));
	}
	
	public static int max(int a, int b) {
		int result = 0;
		
		if(a > b) {
			result = a;
		} else if(a < b) {
			result = b;
		} else {
			result = a;
		}
		
		return result;
	}
}
