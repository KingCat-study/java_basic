package section02;

public class Term {
	public int coef;
	public int expo;
	
	public Term(int coef, int expo) {
		this.coef = coef;
		this.expo = expo;
	}
	
	public int calc(int x) {
		return coef * power(x, expo);
	}
	
	private int power(int a, int b)
	{
		int result = 1;
		
		for (int i = 0; i < b; i++) {
			result = result * a;
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
