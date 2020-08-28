import java.util.Scanner;

/*사용자로부터 n개의 정수를 입력받은 후 그 중 서로 다르면서 차이가 가장 작은 두 수를 찾아 출력하는
프로그램을 작성하라. 입력 형식은 먼저 n의 값이 주어지고 이어서 n개의 정수들이 주어진다. 예를 들
어 n=5이고 정수들이 8, 1, 6, 9, 6이라면 이 중 서로 다르면서 차이가 최소인 두 수는 8과 9이다.*/
public class TaskSet01_07 {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		
		int [] data = new int[n];
		
		for (int i = 0; i < data.length; i++) {
			data[i] = kb.nextInt();
		}
		
		kb.close();
		
		int minBetween = 0;
		
		int number1 = 0;
		int number2 = 0;
		
		for (int i = 0; i < data.length; i++) {
			//뺄셈을 위해선 최소한으로 필요한 수의 갯수가 2개 이상이므로
			if(i == 0) {
				minBetween = data[i] - data[i+1];
				//두 수의 차이 중 가장 작은 수가 1이므로 절대값으로 변환
				if(minBetween < 0) {
					minBetween = minBetween * -1;
				}
			}
			
			for (int j = 0; j < data.length; j++) {
				if(data[i] != data[j]) {
					
					int tmp = data[i] - data[j];
					if(tmp < 0) {
						tmp = tmp * -1;
					}
					
					if(tmp < minBetween) {
						
						minBetween = tmp;
						
						number1 = data[i];
						number2 = data[j];
					}
				}
			}
		}
		
		System.out.println(number1);
		System.out.println(number2);
	}
}
