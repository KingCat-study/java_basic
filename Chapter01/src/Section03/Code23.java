package Section03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
Code 22에

소수점, 쉼표 등의 특수기호가 단어에 포함된다.
숫자 등이 단어로 취급된다.
대문자와 소문자가 다른 단어로 취급된다.
단어들이 알파벳 순으로 정렬되면 좋겠다.

요구사항 추가
*/
public class Code23 {
	
	//개발 시 가장 먼저 자료구조(입력 받을 변수 들 설정) 설정
	
	static String [] words = new String[100000];
	static int [] count = new int[100000];
	static int n = 0;
	
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		while (true) {
			
			System.out.print("$ ");
			String command = kb.next();
			
			if(command.equals("read")) {
				String fileName = kb.next();
				makeIndex(fileName);
			} else if(command.equals("find")) {
				String inputStr = kb.next();
				
				int index = findWord(inputStr);
				
				if(index > -1) {
					System.out.println("The word " + words[index] + " appears "+ count[index] + " times.");
				} else {
					System.out.println("The word "+ inputStr +" does not appears ");
				}
				
			} else if(command.equals("saveas")) {
				String fileName = kb.next();
				saveAsFile(fileName);
			} else if(command.equals("exit")) {
				break;
			}
			
		}
		
		kb.close();
	}
	
	public static void saveAsFile(String fileName) {
		
		try {
			PrintWriter out = new PrintWriter(new FileWriter(fileName));
			
			// 저장 후 출력
			for (int i=0; i<n; i++) {
				out.println(words[i]+ " " + count[i]);
			}
			
			out.close(); 
				 
		} catch (IOException e) {
			System.out.println("파일을 저장하는데에 실패했습니다.");
			e.printStackTrace();
		}
	}
	
	public static void makeIndex(String fileName) {
		
		try {
			
			Scanner inputFile = new Scanner(new File(fileName));
			
			while(inputFile.hasNext()) {
				String str = inputFile.next();
				String trimStr = trimming(str);
				if(trimStr != null) {
					addWord(str.toLowerCase());
				}
				
			}
			
			inputFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			return;
		}
	}
	
	public static void addWord(String word) {
		int index = findWord(word);
		
		if(index > -1) {
			count[index]++;
		} else {
			//ordered List 에 insert <- 배열 끝에서 부터 탐색하는게 탐색 수를 줄일 수 있다.
			int i = n -1;
			
			while(i >= 0 && words[i].compareTo(word) > 0)
			{
				words[i+1] = words[i];
				count[i+1] = count[i];
				i--;
			}
			
			words[i+1] = word;
			count[i+1] = 1;
			n++;
		}
	}
	
	public static int findWord(String keyword) {
		for (int i = 0; i < n; i++) {
			if(words[i] != null && words[i].equals(keyword)) {
				return i;
			} 
		}
		
		return -1;
	}
	
	public static String trimming(String str) {
		if(str == null || str.isEmpty()) {
			return null;
		}
		
		int i = 0;
		int j = str.length()-1;
		
		while(i < str.length() && !Character.isLetter(str.charAt(i))) {
			i++;
		}
		
		while(j >= 0 && !Character.isLetter(str.charAt(j))) {
			j--;
		}
		
		if(i<=j) {
			return str.substring(i,j+1); // [   )  i <=  ....... <= j
		} else {
			return null;
		}
	}
}
