package Section01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
전화번호부 프로그램을 수정하여 다음과 같이 수정하라. 우선 프로그램을 실행하면 data.txt 파일로부터 전화번
호부를 읽는다. 데이터 파일에는 사람 이름과 전화번호의 쌍들이 한 줄에 한 명씩 저장되어 있다. 그런 다음 다음
과 같이 find, add, remove, list, exit 명령을 처리한다.
$ find Kim // Kim의 전화번호를 찾아 출력한다.
010-3423-2234
$ add Park 0103457235 // 새로운 사람을 추가한다.
$ remove Lee // Lee를 삭제한다.
$ list // 모든 사람의 이름과 전화번호를 출력한다.
…
$ exit
*/
public class TaskSet01_03 {

	static Person1[] members;
	static int count = 0;
	
	public static void main(String[] args) {
		
		try {
			Scanner inputFile =  new Scanner(new File("input.txt"));
			
			members = new Person1[1000];
			
			while(inputFile.hasNext()) {
				members[count] = new Person1();
				members[count].name = inputFile.next();
				members[count].number  = inputFile.next();
				count++;
			}
			
			inputFile.close();
			
//			bubbleSort();

			Scanner kb = new Scanner(System.in);
			
			while(true) {
				System.out.print("$ ");
				String command = kb.next();
				
				if(command.equals("exit")) {
					break;
				} else if(command.equals("find")) {
					String name = kb.next();
					
					findNumber(name);
					
				} else if(command.equals("add")) {
					String name = kb.next();
					String number = kb.next();
					
					addPerson(name, number);
					
				} else if(command.equals("remove")) {
					String name = kb.next();
					
					removePerson(name);
				} else if(command.equals("list")) {
					for (int i = 0; i < count; i++) {
						System.out.println(members[i].name + " : " + members[i].number);
					}
				}
			}
			
			kb.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		}
	}
	
	public static void bubbleSort() {
		for (int i = count-1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if(members[j].name.compareToIgnoreCase(members[j+1].name) > 0 ) {
					Person1 tmp =  members[j+1];
					members[j+1] = members[j];
					members[j] = tmp;
				}
			}
		}
	}
	
	public static void findNumber(String name) {
		for (int i = 0; i < count; i++) {
			if(members[i].name.toLowerCase().contains(name.toLowerCase())) {
				System.out.println(members[i].number);
			}
		}
	}
	
	public static void addPerson(String name, String number) {
		members[count] = new Person1();
		members[count].name = name;
		members[count].number  = number;
		count++;
	}
	
	public static void removePerson(String name) {
		for (int i = count-1; i >= 0; i--) {
			if(members[i].name.toLowerCase().contains(name.toLowerCase())) {
				members[i] = members[count-1];
				members[count-1] = null;
				count--;
			}
		}
	}
}
