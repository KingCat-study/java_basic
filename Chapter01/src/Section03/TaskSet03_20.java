package Section03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
Code23은 단어의 앞뒤에 붙은 특수문자들을 제거하지만 중간에 등장하는 특수문자들은 제거하지 못한다.
Code23에서 먼저 단어의 앞뒤에 붙은 특수문자와 숫자들을 제거한 후 남은 단어에 대해서 중간에 영어 알파벳,
hyphen (-), 그리고 underscore(_) 이외의 다른 문자가 포함되면 인덱스에 포함하지 말고 버리도록 프로그램
을 수정하라. 또한 길이가 2 이하인 단어들도 모두 버린다.
*/
public class TaskSet03_20 {
	
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
					addWord(trimStr.toLowerCase());
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
			String regStr = str.substring(i,j+1);// [   )  i <=  ....... <= j
			if(regexMatch(regStr) && regStr.length() >= 3) {
				return regStr; 
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public static boolean regexMatch(String str) {
		String pattern = "^[a-zA-Z_-]*$";
		return str.matches(pattern);
	}
	
}
