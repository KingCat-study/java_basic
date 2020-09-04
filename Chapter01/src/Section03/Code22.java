package Section03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
입력으로 하나의 텍스트 파일을 읽는다 (sample.txt).
텍스트 파일에 등장하는 모든 단어들의 목록을 만들고, 각 단어가 텍스트 파일에
등장하는 횟수를 센다. 단, 단어 개수는 100,000개 이하라고 가정한다.
사용자가 요청하면 단어 목록을 하나의 파일로 저장한다.
사용자가 단어를 검색하면 그 단어가 텍스트 파일에 몇 번 등장하는지 출력한다.

$ read sample.txt // 텍스트 파일 sample.txt를 읽고 인덱스를 만든다.
$ find heaven // heaven이라는 단어가 몇번 나오는지 출력한다.
The word “heaven” appears 13 times.
$ saveas index.txt // 인덱스를 index.txt라는 파일로 저장한다.
$ find java
The word “java” does not appear.
$ exit
*/
public class Code22 {
	
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
				addWord(str);
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			return;
		}
	}
	
	public static void addWord(String str) {
		int index = findWord(str);
		
		if(index > -1) {
			count[index]++;
		} else {
			words[n] = str;
			count[n] = 1;
			n++;
		}
	}
	
	public static int findWord(String keyword) {
		for (int i = 0; i < n; i++) {
			if(words[i].equalsIgnoreCase(keyword)) {
				return i;
			}
		}
		return -1;
	}
}
