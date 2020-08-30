import java.util.Scanner;

//사용자로부터 하나의 양의 정수 n을 입력받는다. 그런 다음 다음과 같이 n줄을 출력하는 프로그램을 작성하라.
//출력 예시 :n=4 인경우
//1
//1 2
//1 2 3
//1 2 3 4
public class TaskSet01_04 {
	
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		
		int [] data = new int[n];
		
		kb.close();
		
		for (int i = 1; i <= data.length; i++) {
			data[i-1] = i;
			for (int j = 0; j <= i-1; j++) {
				System.out.print(data[j] + " ");
			}
			System.out.println();
		}
	}
}
