package repeatsc02;

import repeatsc01.MySingleLinkedList;
import repeatsc01.Node;

public class PolyNomial {
	
	private char name;
	private MySingleLinkedList<Term> terms;
	
	public PolyNomial(char name) {
		this.name = name;
		terms = new MySingleLinkedList<>();
	}
	
	public char getName() {
		return name;
	}

	public void setName(char name) {
		this.name = name;
	}

	public void addTerm(int coef, int expo) {
		
		if(coef == 0) {
			return;
		}
		
		Node<Term> p = terms.head;
		Node<Term> q = null;
		
		while(p != null && p.data.getExpo() > expo) {
			
			q = p;
			p = p.next;
		}

		if(p != null && p.data.getExpo() == expo) {
			p.data.setCoef(p.data.getCoef() + coef);
			
			if(p.data.getCoef() == 0) {
				if(q == null) {
					terms.removeFirst();
				} else {
					terms.removeAfter(q);
				}
			} 
		} else {
			Term addT = new Term(coef, expo);
			
			if(q == null) {
				terms.addFirst(addT);
			} else {
				terms.addAfter(q, addT);
			}
		}
	}

	public int calc(int x) {
		int result = 0;
		
		Node<Term> p = terms.head;
		
		while(p != null) {
			result = result + p.data.calc(x);
			p = p.next;
		}
		
		return result;
	}
	
	@Override
	public String toString() {
//		String result = "";
		StringBuilder sb = new StringBuilder();
		
		Node<Term> p = terms.head;
		
		while(p != null) {
			sb.append("+");
			sb.append(p.data.toString());
//			p = p.next;
//			result = result + "+" + (p.data.toString());
			p = p.next;
		}
		
//		return result;
		return sb.toString();
	}
}
