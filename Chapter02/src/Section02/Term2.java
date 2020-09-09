package Section02;

/*
class Term은 다항식을 구성하는 하나의
항을 표현하기 위한 클래스이다. 계수
(coef)와 차수(expo)를 가진다.

계수는 음이 아닌 정수로 제한

*/
public class Term2 {
	public int coef;
	public int exp;
	
	public int calcTerm(int x) {
		return coef * power(x,exp);
	}
	
	private int power(int a, int b)
	{
		int result = 1;
		
		for (int i = 0; i < b; i++) {
			result = result * a;
		}
		
		return result;
	}
	
	public void printTerm() {
		String str = "";
		// -1 or 1 -> -1x 1x -> -x x
		str = "+";
		if(coef == 1 || coef == -1) {
			str = "-";
			if(coef == 1) {
				str = "+";
			}
			System.out.print(str + "X^" + exp);
		} else if(coef >= 0) {
			System.out.print(str + coef + "X^" + exp);	//  -x^2   ==> -1x^2
		} else {
			System.out.print(coef + "X^" + exp);	//  -x^2   ==> -1x^2
		}
	}
}
