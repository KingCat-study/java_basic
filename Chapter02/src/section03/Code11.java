package section03;

import java.util.Scanner;

/*
Code08의 static 전부 제거
*/
public class Code11 {

	Polynomial3 [] polys = new Polynomial3[1000];
	int n = 0;
	
	public void proccessCommand() {
		Scanner kb = new Scanner(System.in);
		
		while(true) {
			System.out.print("$ ");
			String command = kb.next();
			
			if(command.equals("exit")) {
				break;
			} else if(command.equals("create")) {
				char name = kb.next().charAt(0);
				
				polys[n] = new Polynomial3(name);
				n++;
				
			} else if(command.equals("add")) {
				char name = kb.next().charAt(0);
				int index = find(name);
				
				if(index == -1) {
					System.out.println("입력한 이름의 다항식은 찾을 수 없습니다.");
				} else {
					int coef = kb.nextInt();
					int exp = kb.nextInt();
					polys[index].addTerm(coef, exp);
				}
				
				
			} else if(command.equals("calc")) {
				
				char name = kb.next().charAt(0);
				
				int index = find(name);
				
				if(index == -1) {
					System.out.println("입력한 이름의 다항식은 찾을 수 없습니다.");
				} else {
					int x = kb.nextInt();
					int calcResult =  polys[index].calcPoly(x);
					System.out.println(calcResult);
				}
				
			} else if(command.equals("print")) {
				char name = kb.next().charAt(0);
				
				int index = find(name);
				
				if(index == -1) {
					System.out.println("입력한 이름의 다항식은 찾을 수 없습니다.");
				} else {
					polys[index].printPoly();
				}
			}
		}
		
		kb.close();
		
	}
	
	public static void main(String[] args) {
		Code11 app = new Code11();
		app.proccessCommand();
	}
	
	private int find(char name) {
		for (int i = 0; i < n; i++) {
			if(polys[i].name == name) {
				return i;
			}
		}
		return -1;
	}
}
