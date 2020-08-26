import java.util.Scanner;

public class Code04 {
	public static void main(String[] args) {
		
		String name = null;
		int age;
		String gender;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요.");
		name = keyboard.next();
		
		System.out.println("나이를 입력하세요.");
		age = keyboard.nextInt();
		
		System.out.println("성별을 입력하세요.");
		gender = keyboard.next();
		
		if(gender.equals("male")) {
			System.out.println("age : " + age + " | name : "+name+ " | Man");
		} else if(gender.equals("female")){
			System.out.println("age : " + age + " | name : "+name+ " | WoMan");
		} else {
			System.out.println("What Are U?");
		}
		
		keyboard.close();
	}
}
