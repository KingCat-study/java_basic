package Section02;

/*1~100000 사이의 소수를 찾아 출력한다*/

public class Code17 {
	
	public static void main(String[] args) {
		
		for (int i = 1; i <= 100000; i++) {
			if(isPrime(i)) {
				System.out.println(i);
			}
		}
	}
	
	public static boolean isPrime(int a) {
		
		boolean result = true;
		
		if(a < 2) {
			result = false;
		} else {
			for (int i = 2; i*i < a; i++) {
				if(a % i == 0) {
					result = false;
				}
			}
		}
		
		return result;
	}

}
