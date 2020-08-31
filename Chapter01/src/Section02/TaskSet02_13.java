package Section02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 데이터 파일 input.txt에 사람들의 이름과 나이가 아래 그림과 같은 형식으로 저장되어 있다. 단 이름은 하나의
영문 단어라고 가정한다. 이 데이터 파일을 읽은 후 사람들을 나이순으로 정렬하여 출력하는 프로그램을 작성하
라. 단 나이가 같은 경우에는 이름의 알파벳 순으로 정렬되어야 한다.
*/

public class TaskSet02_13 {

	public static void main(String[] args) {
		
		String [] name = new String[1000];
		int [] age = new int[1000];
		
		try {
			Scanner inputFile = new Scanner(new File("input_taskSet02_13.txt"));
			
			int index = 0;
			while(inputFile.hasNext()) {
				name[index] = inputFile.next();
				age[index] = inputFile.nextInt();
				index++;
			}
			
			inputFile.close();
			
			bubbleSort(name, age, index);
			
			for (int i = 0; i < index; i++) {
					System.out.println(name[i] + " " + age[i]);
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void bubbleSort(String [] name, int [] age, int index) {
		
		for (int i = index-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if(age[j] > age[j+1]) {
					int ageTmp = age[j];
					age[j] = age[j+1];
					age[j+1] = ageTmp;
					
					String nameTmp = name[j];
					name[j] = name[j+1];
					name[j+1] = nameTmp;
							
				} else if(age[j] == age[j+1]) {
					if(name[j].compareToIgnoreCase(name[j+1]) > 0) {
						int ageTmp = age[j];
						age[j] = age[j+1];
						age[j+1] = ageTmp;
						
						String nameTmp = name[j];
						name[j] = name[j+1];
						name[j+1] = nameTmp;
					}
				}
			}
		}
	}
}
