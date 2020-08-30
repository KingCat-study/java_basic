package Section02;

import java.util.Scanner;

/*
사용자로부터 n개의 정수를 입력받은 후 오름차순으로
정렬(sort)하여 출력. 함수 이용 
Call By Value
*/

public class Code18 {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int [] data = new int[n];
		
		for (int i = 0; i < data.length; i++) {
			data[i] = kb.nextInt();
		}
		
		kb.close();
		
		bubbleSort(data);
		
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}
	
	//프리미티브 타입 byte,short,int,long,float,double,char,boolean을 제외한 나머지 타입들은 값에 의한 호출에도 값이 변경.
	public static void bubbleSort(int [] data) {
		for (int i = data.length-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if(data[j] > data[j+1]) {
//					swap(data[j], data[j+1]);//actual parameter
					int tmp = data[j];
					data[j] = data[j+1];
					data[j+1] = tmp;
				}
			}
		}
	}
	
	//실제 정렬 되지 않음 -> 값에 의한 호출 a 와  b 는 data[j] 와 data[j+1] 은 다른 변수 
	//data[] 에는 변화 없음
	public static void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}
}
