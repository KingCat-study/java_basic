package Section01;

/*
한 사람의 “이름”과 “전화번호”는 항상 같이 붙어다녀야 하는 데이터이다.
이 두 가지 데이터를 서로 별개의 변수에 저장하면 우리가 이름 데이터를 옮길 때 마다 전화번호
데이터도 따로 옮겨줘야 한다.
만약 각 사람에 대해서 이름과 전화번호 뿐만 아니라 주소, 이메일 등 여러 가지 데이터를 저장한
다면 이 불편은 더 심해질 것이다.
인덱스 메이커 프로그램에서도 “하나의 단어”와 그 단어의 “등장 횟수”는 항상 같이 붙어다녀야
하는 데이터이다.
이렇게 서로 관련있는 데이터들을 하나의 단위로 묶어두면 편할 것이다.
이것이 클래스라는 개념이 등장하는 가장 기본적인 이유이다.
*/
public class Code01 {

	public static void main(String[] args) {
		
		Person1 first = new Person1();
		
		first.name = "John Lee";
		first.number = "08109993333";
		
//		System.out.println(first.name + " : "+first.number);
		
		Person1 [] members = new Person1[100];
		
		members[0] = first;
		
		members[1] = new Person1();
		
		members[1].name = "Park Gun";
		members[1].number = "081055556666";
		
		for (int i = 0; i < 2; i++) {
			System.out.println(members[i].name + " : "+members[i].number);
		}
	}
}
