//1 ~ 100000 사이의 정수들 중에 가장 작은 50개의 소수를 찾아 그 합을 구하여 출력하는 프로그램
//을 작성하라. 만약 소수의 개수가 50개 미만이라면 모든 소수의 합을 출력하라.
public class TaskSet01_02 {

	public static void main(String[] args) {
		
		//n이 소수인지 판단하는 방법 : 1을 제외 하고 2 ~ n/2까지 수로 n을 나눠서 하나라도 나머지가 없으면 소수 아님.
		//n의 약수가 n/2 보다 클 수 없음
		
		int [] data = new int[50];
		
		int count = 0;
		int sum = 0;
		
		for (int i = 2; i <= 100000; i++) {
			
			boolean isPrime = true;
			
			for (int j = 2; j*j <= i && isPrime; j++) {
				if(i % j == 0) {
					isPrime = false;
				}
			}
			
			if(isPrime) {
//				System.out.println(i);
				data[count] = i;
				count++;
			}
			
			
			if(count >= 50) {
				break;
			}
		}
		
		for (int i = 0; i < data.length; i++) {
//			System.out.println("index : " + i + " : "+ data[i]);
			sum = sum + data[i];
		}
		
		System.out.println("가장 작은 소수 50개의 합은 "+sum);
	}
}
