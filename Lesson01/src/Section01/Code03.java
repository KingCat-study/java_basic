package Section01;
import java.util.Scanner;

public class Code03 {

	public static void main(String[] args) {
		
		String helloStr = "Hello";
		String inputStr = null;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter String : ");
		
		inputStr = keyboard.next();
		
		if(helloStr.equals(inputStr)) {
			//helloStr == inputStr String 은 기본형이 아니기 때문에 == 로 비교할 수 없음
			System.out.println("String Match!!");
		} else {
			System.out.println("String do not Match!!");
		}
		
		keyboard.close();
	}

}
