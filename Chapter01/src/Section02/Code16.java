package Section02;

import java.util.Scanner;

//입력으로 정수 a와  음이 아닌 정수 b를 받아 a의 b승을 계산한다.
public class Code16 {
	
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		int a = kb.nextInt();
		int b = kb.nextInt();
		
		kb.close();
		
		int result = power(a,b);
		System.out.println(result);
	}
	
	public static int power(int a, int b)
	{
		int result = 1;
		
		for (int i = 0; i < b; i++) {
			result = result * a;
		}
		
		return result;
	}
}
