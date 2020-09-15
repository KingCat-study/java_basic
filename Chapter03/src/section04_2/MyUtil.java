package section04_2;

public class MyUtil {
	
	public static void bubbleSort(Comparable [] myComp, int size) {
		for (int i = size-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if(myComp[j].compareTo(myComp[j+1]) > 0){
					Comparable tmp = myComp[j];
					myComp[j] = myComp[j+1];
					myComp[j+1] = tmp;
				}
			}
		}
	}
	
}
