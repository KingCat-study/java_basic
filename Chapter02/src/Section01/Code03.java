package Section01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
이름과 번호를 입력받고
사전순으로 정렬하여 출력한다.
*/
public class Code03 {

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
			
			for (int i = 0; i < count; i++) {
				System.out.println(members[i].name + " : " + members[i].number);
			}
			
			bubbleSort();
			
			System.out.println();
			
			for (int i = 0; i < count; i++) {
				System.out.println(members[i].name + " : " + members[i].number);
			}
			
			
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
}
