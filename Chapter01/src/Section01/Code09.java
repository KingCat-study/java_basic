package Section01;
import java.util.Scanner;

/*n개의 정수를 입력받아 순서대로 배열에 저장한다. 그 런 다음 모든 정수들을 한 칸씩 오른쪽으로 shift하라.
마지막 정수는 배열의 첫 칸으로 이동하라.*/
public class Code09 {
	
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		System.out.println("숫자 배열의 크기를 입력해주세요.");
		int n = kb.nextInt();
		
		int [] data = new int[n];
		
		for (int i = 0; i < data.length; i++) {
			System.out.println((i+1) + "번째 배열에 들어갈 숫자를 입력해주세요.");
			data[i] = kb.nextInt();
		}
		
		kb.close();
		
		System.out.println("모든 정수들을 한 칸씩 오른쪽으로 옮긴 후 마지막 정수는 첫 칸으로 이동합니다.");
		int temp = data[n-1];
		
//		for (int i = n-2; i >= 0; i--) {
//			data[i+1] = data[i];
//		}
		
		for (int i = n-1; i >= 1; i--) {
			data[i] = data[i-1];
		}
		
		data[0] = temp;
		
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
