package Section01;
//사용자로부터 n개의 정수를 입력받는다. 정수가 하나
//씩 입력될 때 마다 현재까지 입력된 정수들을 오름차순
//으로 정렬하여 출력하라
import java.util.Scanner;

public class Code15 {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		
		int [] data = new int[n];
		//이미 정렬된 리스트(Ordered List)에 새로운 값을 넣는 알고리즘
		for (int i = 0; i < data.length; i++) {
			int tmpVal = kb.nextInt();
			int j = i - 1;
			
			while(j >= 0 && data[j] > tmpVal) {
				data[j+1] = data[j];
				j--;
			}
			
			data[j+1] = tmpVal;
			
			for (int k = 0; k <= i; k++) {
				System.out.print(data[k] + " ");
			}
			System.out.println();
 		}
		
		kb.close();
	}
}
