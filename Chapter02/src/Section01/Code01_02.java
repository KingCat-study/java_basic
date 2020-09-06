package Section01;

public class Code01_02 {

	public static void main(String[] args) {
		
		Person1 first = new Person1();
		
		first.name = "John Lee";
		first.number = "08109993333";
		
		Person1 second = first;
		second.name = "Tom";
		System.out.println(first.name + "," + first.number);
		
		int a = 2;
		setInt(a);
		setPerson1(second);
		System.out.println(a);
		System.out.println(first.name);
	}
	
	public static void setInt(int b) {
		b = 3;
		System.out.println(b);
	}

	public static void setPerson1(Person1 b) {
		b.name = "Gon";
		System.out.println(b.name);
	}
	
}
