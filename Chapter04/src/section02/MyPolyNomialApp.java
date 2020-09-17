package section02;

import java.util.Scanner;

public class MyPolyNomialApp {

	final int init_capacity = 100;
	private Polynomial [] polys = new Polynomial[init_capacity];
	private int n = 0;
	Scanner kb = new Scanner(System.in);
	
	private void processorCommand() {
		
		while(true)
		{
			System.out.println("$ ");
			
			String cmd = kb.next();
			
			if(cmd.equals("exit")) {
				break;
			} else if(cmd.equals("create")) {
				handleCreate();
			} else if(cmd.equals("add")) {
				handleAdd();
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
		int index = find(name);
		
		if(index < 0) {
			System.out.println("해당 이름의 다항식이 존재하지 않습니다.");
		} else {
			System.out.println(polys[index].calc(x));
		}
	}

	private void handlePrint() {
		char name = kb.next().charAt(0);
		
		int index = find(name);
		
		if(index < 0) {
			System.out.println("해당 이름의 다항식이 존재하지 않습니다.");
		} else {
			System.out.println(polys[index].toString());
		}
	}

	private void handleAdd() {
		char name = kb.next().charAt(0);
		int coef = kb.nextInt();
		int expo = kb.nextInt();
		
		int index = find(name);
		
		if(index < 0) {
			System.out.println("해당 이름의 다항식이 존재하지 않습니다.");
		} else {
			polys[index].addTerm(coef, expo);
		}
	}

	private void handleCreate() {
		char name = kb.next().charAt(0);
		
		Polynomial p = new Polynomial(name);
		insert(p);
	}

	private void reallocate() {
		Polynomial [] tmp = new Polynomial [2*polys.length];
		System.arraycopy(polys, 0, tmp, 0, polys.length);
		polys = tmp;
	}
	
	private void insert(Polynomial polynomial) {
		int index = find(polynomial.name);
		if (index>-1)
			polys[index] = polynomial;
		else {
			if (polys.length<=n)
				reallocate();
			polys[n++] = polynomial;
		}
	}
	
	private int find(char name) {
		for (int i=0; i<n; i++) {
			if (polys[i].name == name)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {

		MyPolyNomialApp app = new MyPolyNomialApp();
		app.processorCommand();
	}

}
