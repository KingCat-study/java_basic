package Section01;
import java.util.Scanner;

//n개의 음이 아닌 한 자리 정수를 입력받아 배열에 저장한다. 이들
//중에서 1개 이상의 연속된 정수들을 합하여(?) 얻을 수 있는 소수
//들 중에서 최대값을 구하여 출력하는 프로그램을 작성하라.

public class Code13 {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		
		int [] data = new int[n];
		
		for (int i = 0; i < data.length; i++) {
			data[i] = kb.nextInt();
		}
		
		kb.close();
		
		int maxPrime = 0;
		
		for (int i = 0; i < data.length; i++) {
			for (int j = i; j < data.length; j++) {
				// [1,9,4] => 194 변환 과정
				// val = 0
				// val = 0 * 10 + (data[k] = 1)  = 1;
				// val = 1 * 10 + (data[k] = 9)  = 19;
				// val = 19 * 10 + (data[k] = 4) = 194;
				// 시작점 i , 끝점 j
				int val = 0;
				for (int k = i; k <=j; k++) {
					val = val * 10 + data[k];
				}
				
				//소수 인지 아닌지 체크
				boolean isPrime = true;
				for (int p = 2; p*p <= val && isPrime; p++) {
					if(val % p == 0) {
						isPrime = false;
					}
				}
				
				//소수이면 지금까지 알고 있는 가장 큰 소수와 비교 후 큰 소수 결정
				if(isPrime && val > 1 && val > maxPrime) {
					maxPrime = val;
				}
			}
		}
		
		//maxPrime 이 0 이라면 소수를 찾을 수 없었단 뜻
		if(maxPrime > 0) {
			System.out.println("소수들 중 최대 값은 " + maxPrime);
		} else {
			System.out.println("소수가 없음.");
		}
	}
}
