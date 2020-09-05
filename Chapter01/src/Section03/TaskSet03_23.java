package Section03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
Code20에서 사용자로 부터 이름과 전화번호 쌍들을 입력받아 저장하고, 이름의 알파벳 순으로 정렬하여 출력하
는 일을 하였다. 이 프로그램을 다음과 같이 수정하라. 우선 입력을 키보드가 아니라 input.txt라는 이름의 파일
로 부터 받는다. 사람 수는 최대 1000명이라고 가정한다. Code20에서 사람 이름은 항상 한 단어라고 가정하였
다. 이름이 여러 단어로 구성될 수 있도록 수정한다. 이때 이름과 전화번호를 구분하기 위한 구분자로 ‘|” 문자를
사용한다. 아래는 입력 파일의 예이다. 입력 파일에는 단어의 앞뒤로 불필요한 공백이 있을 수 있다. 출력에서는
불필요한 공백들을 모두 제거해야 한다.

입력 파일의 예: directory.txt
Hong Gildong | 010-7624-4867
Lee Sang Ho | 051-475-3845
 David Lee | 32875628234
Junho Kim | 2346923479
 Park Hyung-Woo | 02-4574-4857

출력 예: 화면으로 출력 
David Lee | 32875628234
Hong Gildong | 010-7624-4867
Junho Kim | 2346923479
Lee Sang Ho | 051-475-3845
Park Hyung-Woo | 02-4574-4857

*/

public class TaskSet03_23 {

	static String name[];
	static String number[];
	static int index = 0;
	
	public static void main(String[] args) {
	
		name = new String[1000];
		number = new String[1000];
		
		try {
			
			Scanner inputFile = new Scanner(new File("input_testSet03_23.txt"));

			while (inputFile.hasNext()) {
				String strLine = inputFile.nextLine();
				
				int i = 0;
				int indexOfchar = strLine.indexOf("|");
				
				while(i < indexOfchar && Character.isLetter(strLine.charAt(i))) {
					i++;
				}
				
				String firstName = strLine.substring(0,i);
				String lastName = strLine.substring(i, indexOfchar).replace(" ", "");
				String numberStr = strLine.substring(indexOfchar+1).replace(" ", "");
				
				name[index] = firstName + " " + lastName;
				number[index]  = numberStr;
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
			System.out.println(name[i] + " | "+ number[i]);
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
