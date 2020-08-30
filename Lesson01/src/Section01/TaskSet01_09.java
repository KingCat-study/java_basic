import java.util.Scanner;

/*사용자로부터 n개의 정수를 입력받아 배열에 저장한 후 짝수 인덱스에 저장된 수는 그대로 두고 홀수
인덱스에 저장된 수들은 오름차순으로 정렬하여 출력하는 프로그램을 작성하라. 예를 들어 입력된 정수
들이 1 7 4 12 5 10 9 7이라면 출력은 1 7 4 7 5 10 9 12이다.*/
public class TaskSet01_09 {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		
		int [] data = new int[n];
		
		for (int i = 0; i < data.length; i++) {
			data[i] = kb.nextInt();
		}
		
		kb.close();
		
//		int [] data = {1, 7, 4, 12, 5, 10, 9, 7}; 
		
		for (int i = data.length-1; i >= 0; i--) {
			if(i % 2 == 1) {
				for (int j = 1; j < i; j +=2) {
					if(data[j] > data[j+2]) {
						int tmp = data[j+2];
						data[j+2] = data[j];
						data[j] = tmp;
					}
				}
			}
		}
		
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}
}
