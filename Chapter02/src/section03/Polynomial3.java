package section03;

/*
class Polynomial은 하나의 다항식을 표현
하기 위한 클래스이다.
*/
public class Polynomial3 {
	//다항의 이름은 한개의 캐릭터로 제한
	private char name;
	//다항안에 포함되어 있는 총 갯수
	private int nTerms;
	private Term3[] terms;
	
	public Polynomial3() {
		nTerms = 0;
		terms = new Term3[100];
	}
	
	public Polynomial3(char name) { 
		nTerms = 0;
		terms = new Term3[100];
		this.name = name;
	}
	
	public int calcPoly(int x) {
		int result = 0;
		
		for (int i = 0; i < nTerms; i++) {
			result = result + terms[i].calcTerm(x);
		}
		
		return result;
	}
	
	//마지막 + 는 출력 되지 않아야 함
	public void printPoly() {
		for (int i = 0; i < nTerms; i++) {
			terms[i].printTerm();
		}
		System.out.println();
	}
	
	public void addTerm(int coef, int exp) {
		
		int index = findTerm(exp);
		if(index != -1) {
			// -5x^3 이 있고 add 로 +5x^3 이 들어 왔으면 0이 되므로 terms 에서 제거.
			if((terms[index].getCoef() + coef) == 0) {
				for (int i = index; i < nTerms-1; i++) {
					terms[i] = terms[i+1];
				}
				
				terms[nTerms-1] = null;
				nTerms--;
				
			} else {
				terms[index].setCoef(terms[index].getCoef() + coef);
			}
		} else {
			
			int i = nTerms-1;
			//내림차순
			//오름 차순이면 부등호는 >
			while(i >= 0 && terms[i].getExp() < exp) {
				terms[i+1] = terms[i];
				i--;
			}
			
			terms[i+1] = new Term3(coef,exp);
			nTerms++;
		}
	}
	
	public int findTerm(int exp) {
		//아래 방법 보다 더 좋은 방법은 이항검색
		for (int i = 0; i < nTerms && terms[i].getExp() >= exp; i++) {
			if(terms[i].getExp() == exp) {
				return i;
			}
		}
		return -1;
	}

	public char getName() {
		return name;
	}

	public void setName(char name) {
		this.name = name;
	}

	public int getnTerms() {
		return nTerms;
	}

	public void setnTerms(int nTerms) {
		this.nTerms = nTerms;
	}

	public Term3[] getTerms() {
		return terms;
	}

	public void setTerms(Term3[] terms) {
		this.terms = terms;
	}
	
}
