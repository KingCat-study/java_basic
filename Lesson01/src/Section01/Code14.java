package Section01;
import java.util.Scanner;
//사용자로부터 n개의 정수를 입력받은 후 오름차순으로
//정렬(sort)하여 출력하는 코드이다.
//버블 정렬(bubble Sort) 알고리즘 = 가장 큰 값을 배열 끝자리로 옮기기
public class Code14 {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		
		int [] data = new int[n];
		
		for (int i = 0; i < data.length; i++) {
			data[i] = kb.nextInt();
		}
		
		kb.close();
		
		//가장 큰수가 배열 끝 자리로 가게 되면 해당 인덱스는 조회할 필요가 없으므로 i = n -1 
		for (int i = n - 1; i > 0; i--) {
			//배열의 인덱스 0 부터 i 까지 데이터를 비교
			for (int j = 0; j < i; j++) {
				//현재 인덱스의 값이 현재 인덱스 +1 의 값보다 크다면 값 교체.
				if(data[j] > data[j+1]) {
					int tmp = data[j+1];
					data[j+1] = data[j];
					data[j] = tmp;
				}
			}
		}
		
		System.out.println("버블 정렬 된 데이터");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]+" ");
		}
	}
}
