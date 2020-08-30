import java.util.Scanner;

//사용자로 부터 n개의 정수를 받아서 그 중 최대값에서 최소값을 뺀 값을 계산해 출력하는 프로그램을 작성하라. 
//입력 형식은 TaskSet01_03번과 동일하다.
public class TaskSet01_05 {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		
		int [] data = new int[n];
		
		for (int i = 0; i < data.length; i++) {
			data[i] = kb.nextInt();
		}
		
		kb.close();
		
		int min = data[0];
		int max = data[0];
		int sum = 0;
		
		for (int i = 0; i < data.length; i++) {
			sum = sum + data[i];
			
			if(min > data[i]) {
				min = data[i];
			} else if (max < data[i]) {
				max = data[i];
			}
		}
		
		System.out.println(sum-(max+min));
	}

}
