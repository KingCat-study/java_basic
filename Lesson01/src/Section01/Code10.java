package Section01;

//1~100000 사이의 모든 소수들을 찾아서 출력

public class Code10 {
	
	public static void main(String[] args) {
		
		//n이 소수인지 판단하는 방법 : 1을 제외 하고 2 ~ n/2까지 수로 n을 나눠서 하나라도 나머지가 없으면 소수 아님.
		//n의 약수가 n/2 보다 클 수 없음
		//sqrt(n)-루트n 까지 
		
//		int n = 10111;
		int count = 0;
		for(int n = 2; n <= 100000; n++) {
			
			boolean isPrime = true;
			
			//i*i <= n 루트 
			//방법 1
			for (int i = 2; i*i <= n && isPrime; i++) {
				if(n % i == 0) {
					//소수 아님
					isPrime = false;
				}
			}
			
			//방법 2
//			for (int i = 2; i*i <= n; i++) {
//				if(n % i == 0) {
//					//소수 아님
//					isPrime = false;
//					break;
//				}
//			}
			
			if(isPrime) {
				System.out.println(n+"은 소수 ");
				count++;
			} 
		}
		
		System.out.println(count);
	}
}
