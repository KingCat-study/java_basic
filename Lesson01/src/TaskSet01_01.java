//1 ~ 100000 사이의 정수들 중 소수의 개수를 세어 출력하는 프로그램을 작성하라.
public class TaskSet01_1 {

	public static void main(String[] args) {

		int count = 0;
		for (int i = 2; i <= 100000; i++) {
			
			boolean isPrime = true;
			
			for (int j = 2; j*j <= i; j++) {
				
				if(i % j == 0)
				{
					isPrime = false;
				}
			}
			
			if(isPrime) {
				count++;
			}
		}
		System.out.println(count);
	}
}
