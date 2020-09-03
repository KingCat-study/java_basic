package Section02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
파일 input.txt에 여러 개의 단어들이 한 줄에 하나씩 주어진다. 이 파일을 읽어서 배열에 저장한다. 키보드로부
터 문자의 개수 n과 이어서 n개의 문자들을 입력받아 문자 배열에 저장한다. 이 배열에서 파일에 등장하는 모든
단어들을 찾아 출력하는 프로그램을 작성하라. 
*/


public class TaskSet02_16 {

	public static void main(String[] args) {
		
		try {
			Scanner inputFile = new Scanner(new File("input_taskSet02_16.txt"));
			
			String [] inputData = new String[1000];
			
			int index = 0;
			while(inputFile.hasNext()) {
				inputData[index] = inputFile.next();
				index++;
			}
			
			inputFile.close();
			
			Scanner kb = new Scanner(System.in);
			
			int n = kb.nextInt();
			
			String [] data = new String[n];
			
			for (int i = 0; i < data.length; i++) {
				data[i] = kb.next();
			}
			
			kb.close();
			
//			String [] data = {"a", "b", "a", "t", "m", "a", "n", "o", "t", "r", "u", "e", "s"};
			
			for (int i = 0; i < data.length; i++) {
				String str = data[i];

				for (int k = 0; k < index; k++) {
					if(inputData[k].equals(str)) {
						System.out.println(str);
					}
				}
				
				for (int j = i+1; j < data.length; j++) {
					str = str + data[j];
					
					for (int k = 0; k < index; k++) {
						if(inputData[k].equals(str)) {
							System.out.println(str);
						}
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		}
	}

}
