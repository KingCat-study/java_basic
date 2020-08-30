package Section02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
input.txt라는 파일로 부터 사람들의 이름과
전화번호 쌍을 입력받아 배열에 저장하고 출력한다.
*/

public class Code19 {
	
	public static void main(String[] args) {
		
		String fileName = "input.txt";

		String [] name = new String[1000];
		String [] number = new String[1000];
		
		int index = 0;
		
		try {
			
			Scanner inputFile = new Scanner(new File(fileName));
			
			while(inputFile.hasNext())
			{
				name[index] = inputFile.next();
				number[index] = inputFile.next();
				index++;
			}
			
			inputFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재 하지 않습니다.");
			System.exit(9);
			e.printStackTrace();
			return;
		}
		
		for (int i = 0; i < index; i++) {
			System.out.println("이름 : " + name[i] + " | 전화번호 : "+ number[i]);
		}
	}
}
