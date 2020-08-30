package Section02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
input.txt 파일로부터 이름과 전화번호 쌍을 입력받은 후 이름의 알파벳 순서로 정렬하여 출력한다.

*/

public class Code20 {

	static String name[];
	static String number[];
	static int index = 0;
	
	public static void main(String[] args) {
	
		name = new String[1000];
		number = new String[1000];
		
		try {
			
			Scanner inputFile = new Scanner(new File("input.txt"));
			
			while (inputFile.hasNext()) {
				name[index] = inputFile.next();
				number[index] = inputFile.next();
				index++;
			}
			
			inputFile.close();
			
			bubbleSort();
			
		} catch (FileNotFoundException e) {
			
			System.out.println("파일이 존재 하지 않습니다.");
			e.printStackTrace();
			System.exit(9);
		}
		
		for (int i = 0; i < index; i++) {
			System.out.println("이름 : " + name[i] + " | 전화번호 : "+ number[i]);
		}
	}

	private static void bubbleSort() {
		for(int i= index-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if(name[j].compareToIgnoreCase(name[j+1]) > 0) {
					String nameTmp = name[j];
					name[j] = name[j+1];
					name[j+1] = nameTmp;
					
					String numberTmp = number[j];
					number[j] = number[j+1];
					number[j+1] = numberTmp;
				}
			}
		}
	}
	
}
