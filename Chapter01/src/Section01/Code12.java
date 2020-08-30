package Section01;
import java.util.Scanner;

//n개의 정수를 입력받아 배열에 저장한다. 이들 중에서 0개 이
//상의 연속된 정수들을 더하여 얻을 수 있는 최대값을 구하여
//출력하는 프로그램을 작성하라.
//즉 수를 선택 한 후 더했을 때 합이 가장 큰수를 출력.
public class Code12 {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int [] data = new int[n];
		
		for (int i = 0; i < data.length; i++) {
			data[i] = kb.nextInt();
		}
		
		kb.close();
		
		int maxVal = 0;
		
//		for (int i = 0; i < data.length; i++) {
//			for (int j = i; j < data.length; j++) {
//				//add data[i] + data[j]
//				// if the sum > max
//				// max = the sum;
//				int sum = 0;
//				for (int k = i; k <= j; k++) {
//					sum = sum + data[k];
//				}
//				
//				if (sum > maxVal) {
//					maxVal = sum;
//				}
//			}
//		}
		
		//위 코드 개선
		for (int i = 0; i < data.length; i++) {
			int sum = 0;
			for (int j = i; j < data.length; j++) {
				sum = sum + data[j];
				
				if (sum > maxVal) {
					maxVal = sum;
				}
			}
		}
		
		System.out.println(maxVal);
	}
}
