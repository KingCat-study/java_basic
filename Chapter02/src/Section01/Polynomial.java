package Section01;

/*
class Polynomial은 하나의 다항식을 표현
하기 위한 클래스이다.
*/
public class Polynomial {
	//다항의 이름은 한개의 캐릭터로 제한
	public char name;
	//다항안에 포함되어 있는 총 갯수
	public int nTerms = 0;
	public Term[] terms = new Term[100];
}
