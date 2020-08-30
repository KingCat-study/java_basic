import java.util.Scanner;

/*사용자로부터 하나의 양의 정수 n을 입력받고 이어서 n개의 정수가 입력된다. 그런 다음 다시 하나의
정수 K가 입력된다. n개의 정수들 중에서 2개의 정수를 선택해 그 합이 K가 되는 경우의 수를 카운트
하는 프로그램을 작성하라. 단 같은 정수를 중복 선택하는 것은 허용하지 않는다.*/
public class TaskSet01_10 {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		
		int [] data = new int[n];
		
		for (int i = 0; i < data.length; i++) {
			data[i] = kb.nextInt();
		}
		
		int k = kb.nextInt();
		
		kb.close();
		
		
//		int [] data = {1, 7, 4, 12, 6, 10, 9, 7}; 
		
		int [] usedVal = new int[data.length];
		
//		int k = 16;
		
		int count = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if(data[i] != data[j] & i != j) {
					
					boolean usedFlag = false;
					
					for (int p = 0; p < usedVal.length; p++) {
						if(usedVal[p] == data[i] | usedVal[p] == data[j]) {
							usedFlag = true;
						}
					}
					
					if(k == (data[i] + data[j]) && !usedFlag) {
						usedVal[count*2] = data[i];
						usedVal[(count*2)+1] = data[j];
						count++;
					}
				}
			}
		}
		
		System.out.println(count); 
	}

}
