import java.util.Scanner;

/*사용자로부터 하나의 양의 정수 n을 입력받는다. n보다 크거나 같으면서 가장 작은 2의 거듭제곱수를
찾아서 출력하는 프로그램을 작성하라. 예를 들어 n=12이면 출력은 24=16이다*/
public class TaskSet01_06 {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		
		kb.close();
		
		int result = 1;
		
		for (int i = 1; i <= n; i++) {
			result = result * 2;
			if(result > n) {
				break;
			}
		}
		
		System.out.println(result);
	}
}
