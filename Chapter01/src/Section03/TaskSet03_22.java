package Section03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
testSet03_21번 문제에서 작성한 코드에 test명령을 추가한다.
어떤 단어가 단어 내의 문자들의 순서만 바꾸어서 다른 단어와 동일해질 수 있을 때 그 단어는 다른 단어의
anagram이라고 부른다. 예를 들어 orchestra는 carthorse의 anagram이다. 입력으로 키보드로 부터 두 단
어를 받아서 서로 anagram 관계인지 검사하는 프로그램을 작성하라. 다음과 같이 작동해야 한다.

$ test orchestra carthorse
yes
$ test power person
no
$ exit

*/
public class TaskSet03_22 {
	
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
			} else if(command.equals("test")) {
				String leftKwd = kb.next();
				String rightKwd = kb.next();
				
				if(leftKwd != null && rightKwd != null) {
					isAnagram(leftKwd, rightKwd);
				}
			}
			
		}
		
		kb.close();
	}
	
	public static void isAnagram(String leftStr, String rightStr) {
		if(leftStr.length() == 0 || rightStr.length() == 0 || leftStr.length() != rightStr.length()) {
			System.out.println("no");
		} else {
			
			for (int i = 0; i < leftStr.length(); i++) {
				if(rightStr.indexOf(leftStr.charAt(i)) == -1) {
					System.out.println("no");
					return;
				}
			}
			
			System.out.println("yes");
		}
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
