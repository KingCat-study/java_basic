package Section03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
testSet03_20번 문제에서 작성한 코드에 search명령을 추가한다. search 명령을 실행하면 사용자가 지정한 단어를 접두
어로 포함하는 모든 단어와 등장 횟수를 찾아 출력한다. 예를 들어 어떤 단어가 the를 접두어로 가지고 있는지 알
려면 일단 그 단어는 길이가 3 이상이어야 하고, 그 단어의 앞 3글짜를 떼어내면 the가 되어야 한다. 어떤 단어
의 일부분만 떼어내기 위해서는 substring 메서드를 사용한다.
*/
public class TaskSet03_21 {
	
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
			} else if(command.equals("search")) {
				String searchStr = kb.next();
				
				if(searchStr != null && searchStr.length() < 3) {
					System.out.println("검색 할 단어는 3자리 이상이어야 합니다.");
				} else {
					searchStrInIndex(searchStr);
				}
			}
			
		}
		
		kb.close();
	}
	
	public static void searchStrInIndex(String searchKwd) {
		for (int i = 0; i < n; i++) {
			if(words[i] != null && words[i].substring(0, 3).equalsIgnoreCase(searchKwd)) {
				System.out.println(words[i] + " " + count[i]);
			}
		}
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
