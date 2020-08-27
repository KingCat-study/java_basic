import java.util.Scanner;


//사용자로부터 n개의 정수를 입력받은 후 합과 최 대값을 구하여 출력하는 코드
public class Code08 {
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("숫자 배열의 크기를 입력해주세요.");
		int n = keyboard.nextInt();
		
		int [] data = new int[n];
		
		for (int i = 0; i < data.length; i++) {
			System.out.println((i+1) + "번째 배열에 들어갈 숫자를 입력해주세요.");
			data[i] = keyboard.nextInt();
		}
		
		keyboard.close();
		
		int sum = 0;
		int max = data[0];
		
		for (int i = 0; i < data.length; i++) {
			sum = sum + data[i];
			
			if(data[i] > max) {
				max = data[i];
			}
		}
		
		System.out.println("합계 : "+ sum + " | 가장 큰 수 : " + max);
	}
}
