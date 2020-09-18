package repeatsc02;

import java.util.Scanner;

public class MyPolyNomialAppRp {

	int size = 0;
	final int INIT_CAPACITY = 100;
	PolyNomial [] polys = new PolyNomial[INIT_CAPACITY];
	Scanner kb = new Scanner(System.in);
	
	private void processorCommand() {
		
		while(true) {
			System.out.print("$ ");
			String cmd = kb.next();
			
			if(cmd.equals("create")) {
				handleCreate();
			} else if(cmd.equals("add")) {
				handleAdd();
			} else if(cmd.equals("exit")) {
				break;
			} else if(cmd.equals("print")) {
				handlePrint();
			} else if(cmd.equals("calc")) {
				handleCalc();
			}
		}
		
		kb.close();
	}
	
	private void handleCalc() {
		char name = kb.next().charAt(0);
		int x = kb.nextInt();
		
		int index = findPoly(name);
		
		if(index < 0) {
			System.out.println("해당 이름의 다항함수가 없습니다.");
		} else {
			System.out.println(polys[index].calc(x));
		}
	}

	private void handlePrint() {
		char name = kb.next().charAt(0);
		
		int index = findPoly(name);
		
		if(index < 0) {
			System.out.println("해당 이름의 다항함수가 없습니다.");
		} else {
			System.out.println(polys[index].toString());
		}
	}

	private void handleAdd() {
		char name = kb.next().charAt(0);
		
		int coef = kb.nextInt();
		int expo = kb.nextInt();
		
		int index = findPoly(name);
		
		if(index < 0) {
			System.out.println("해당 이름의 다항함수가 없습니다.");
		} else {
			polys[index].addTerm(coef,expo);
		}
	}

	private void handleCreate() {
		char name = kb.next().charAt(0);
		
		PolyNomial poly = new PolyNomial(name);
		insert(poly);
	}
	
	private void insert(PolyNomial p) {
		int index = findPoly(p.getName());
		
		if(index > -1) {
			polys[index] = p;
		} else {
			if(polys.length >= size) {
				reallocation();
			}
			polys[size++] = p;
		}
	}
	
	private int findPoly(char name) {
		
		for (int i = 0; i < size; i++) {
			if(polys[i].getName() == name) {
				return i;
			}
		}
		return -1;
	}
	
	private void reallocation() {
		PolyNomial [] tmp = new PolyNomial[INIT_CAPACITY*2];
		
		for (int i = 0; i < size; i++) {
			tmp[i] = polys[i];
		}
		
		polys = tmp;
	}

	public static void main(String[] args) {
		MyPolyNomialAppRp app = new MyPolyNomialAppRp();
		app.processorCommand();
	}

}
