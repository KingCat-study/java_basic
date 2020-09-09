package Section02;

import java.util.Scanner;

/*
다항함수(polynomial)는 항(term)들의 합이며, 항(term)은 계수(coefficient)
와 지수(exponent)에 의해서 정의된다. 계수는 0이 아닌 정수이고 지수는 음이
아닌 정수라고 가정한다. 예를 들면, 
f(x) = -x5 + 2x4 -10x - 3
27프로그램 실행 예
$ create f // 다항함수 f = 0을 정의한다.
$ add f 2 3 // f(x)에 2x3을 더한다. 따라서 f(x) = 2x3 이 된다.
$ add f -1 1 // f(x) = 2x3 - x 이 된다.
$ add f 5 0 // f(x) = 2x3 - x + 5 이 된다.
$ add f 2 1 // f(x) = 2x3 - x + 5 + 2x = 2x3 + x + 5 이 된다.
$ calc f 2 // x=2일 때 다항함수 f의 값, 즉 f(2) = 23을 계산하여 출력한다.
23
$ print f // 차수에 관한 내림차순으로 정렬하여 다음과 같이 출력한다.
2x^3 + x + 5 // 동일한 차수의 항은 하나로 합쳐져야 한다.
$ create g // 다른 다항 함수 g를 정의한다.
….
$ exit
*/
public class Code08 {

	static Polynomial3 [] polys = new Polynomial3[1000];
	static int n = 0;
	
	public static void main(String[] args) {

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
	
	private static int find(char name) {
		for (int i = 0; i < n; i++) {
			if(polys[i].name == name) {
				return i;
			}
		}
		return -1;
	}
}
