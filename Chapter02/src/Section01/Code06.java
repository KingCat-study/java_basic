package Section01;

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
public class Code06 {

	static Polynomial [] polys = new Polynomial[1000];
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
				
				polys[n] = new Polynomial();
				polys[n].name = name;
				n++;
				
			} else if(command.equals("add")) {
				char name = kb.next().charAt(0);
				int index = find(name);
				
				if(index == -1) {
					System.out.println("입력한 이름의 다항식은 찾을 수 없습니다.");
				} else {
					int coef = kb.nextInt();
					int exp = kb.nextInt();
					addTerm(polys[index], coef, exp);
				}
				
				
			} else if(command.equals("calc")) {
				
				char name = kb.next().charAt(0);
				
				int index = find(name);
				
				if(index == -1) {
					System.out.println("입력한 이름의 다항식은 찾을 수 없습니다.");
				} else {
					int x = kb.nextInt();
					int calcResult =  calcPoly(polys[index],x);
					System.out.println(calcResult);
				}
				
			} else if(command.equals("print")) {
				char name = kb.next().charAt(0);
				
				int index = find(name);
				
				if(index == -1) {
					System.out.println("입력한 이름의 다항식은 찾을 수 없습니다.");
				} else {
					printPoly(polys[index]);
				}
			}
		}
		
		kb.close();
		
	}
	
	private static int calcTerm(Term t, int x) {
		return t.coef * power(x,t.exp);
	}
	
	private static int calcPoly(Polynomial poly, int x) {
		int result = 0;
		
		for (int i = 0; i < poly.nTerms; i++) {
			result = result + calcTerm(poly.terms[i],x);
		}
		
		return result;
	}
	
	
	
	private static void printTerm(Term t) {
		String str = "";
		// -1 or 1 -> -1x 1x -> -x x
		str = "+";
		if(t.coef == 1 || t.coef == -1) {
			str = "-";
			if(t.coef == 1) {
				str = "+";
			}
			System.out.print(str + "X^" + t.exp);
		} else if(t.coef >= 0) {
			System.out.print(str + t.coef + "X^" + t.exp);	//  -x^2   ==> -1x^2
		} else {
			System.out.print(t.coef + "X^" + t.exp);	//  -x^2   ==> -1x^2
		}
	}
	
	//마지막 + 는 출력 되지 않아야 함
	private static void printPoly(Polynomial poly) {
		for (int i = 0; i < poly.nTerms; i++) {
			printTerm(poly.terms[i]);
		}
		System.out.println();
	}
	
	private static int find(char name) {
		for (int i = 0; i < n; i++) {
			if(polys[i].name == name) {
				return i;
			}
		}
		return -1;
	}
	
	private static void addTerm(Polynomial poly, int coef, int exp) {
		
		int index = findTerm(poly, exp);
		if(index != -1) {
			// -5x^3 이 있고 add 로 +5x^3 이 들어 왔으면 0이 되므로 terms 에서 제거.
			if((poly.terms[index].coef + coef) == 0) {
				for (int i = index; i < poly.nTerms-1; i++) {
					poly.terms[i] = poly.terms[i+1];
				}
				
				poly.terms[poly.nTerms-1] = null;
				poly.nTerms--;
				
			} else {
				poly.terms[index].coef = poly.terms[index].coef + coef;
			}
		} else {
			
			int i = poly.nTerms-1;
			//내림차순
			//오름 차순이면 부등호는 >
			while(i >= 0 && poly.terms[i].exp < exp) {
				poly.terms[i+1] = poly.terms[i];
				i--;
			}
			
			poly.terms[i+1] = new Term();
			poly.terms[i+1].coef = coef;
			poly.terms[i+1].exp = exp;
			poly.nTerms++;
		}
	}
	
	private static int findTerm(Polynomial poly, int exp) {
		//아래 방법 보다 더 좋은 방법은 이항검색
		for (int i = 0; i < poly.nTerms && poly.terms[i].exp >= exp; i++) {
			if(poly.terms[i].exp == exp) {
				return i;
			}
		}
		return -1;
	}
	
	public static int power(int a, int b)
	{
		int result = 1;
		
		for (int i = 0; i < b; i++) {
			result = result * a;
		}
		
		return result;
	}
}
