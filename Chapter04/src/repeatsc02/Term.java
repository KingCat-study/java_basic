package repeatsc02;

public class Term {

	private int coef;
	private int expo;
	
	public int getCoef() {
		return coef;
	}

	public void setCoef(int coef) {
		this.coef = coef;
	}

	public int getExpo() {
		return expo;
	}

	public void setExpo(int expo) {
		this.expo = expo;
	}

	public Term(int coef, int expo) {
		this.coef = coef;
		this.expo = expo;
	}
	
	public int calc(int x) {
		return coef * power(x,expo);
	}
	
	private int power(int x,int expo) {
		int result = 1;
		
		for (int i = 0; i < expo; i++) {
			result = result * x;
		}
		
		return result;
	}

	@Override
	public String toString() {
		if(coef == 1) {
			return "X^" + expo;
		} else if(coef == -1) {
			return "-X^" + expo;
		} else {
			return coef + "X^" + expo;
		}
	}
	
}
