import java.util.Scanner;

public class Code02 {
	
	public static void main(String[] args) {
		
		int number = 123;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter an integer : ");
		
		int input = keyboard.nextInt();
		
		if (input == number) {
			System.out.println("Number Match! ");
		} else {
			System.out.println("Number do not Match!");
		}
		
		keyboard.close();
	}
}
