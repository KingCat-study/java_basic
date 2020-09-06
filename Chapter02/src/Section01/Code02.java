package Section01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
데이터 파일로 부터 사람들의 이름과 전
화번호를 입력받아 배열 members에 저
장한 후, 입력된 순서대로 출력하려고 한
다. 이 코드에서 잘못된 점들을 모두 찾
아서 수정하라.
*/
public class Code02 {

	static Person1[] members;
	static int count = 0;;
	
	public static void main(String[] args) {
		
		try {
			Scanner inputFile =  new Scanner(new File("data.txt"));
			
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
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		}
		
	}
}
