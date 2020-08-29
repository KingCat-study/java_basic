import java.util.Scanner;

/*입력으로 두 행렬(p*q 행렬과 q*r행렬)을 받아서 두 행렬을 곱하는 프로그램을 작성하라. 입력의 형식
은 다음과 같다. 먼저 첫 줄에는 첫 번째 행렬의 크기 p와 q가 주어지고, 이어지는 p줄에는 각 줄마다
q개의 정수가 주어진다. 다음으로 두번째 행렬의 크기 q와 r이 주어지고, 마찬가지로 이어지는 q줄에
는 각 줄마다 r개의 정수가 주어진다. 두 행렬의 곱을 구하여 출력한다*/
//공식 Cij = 시그마k=1, Aik * Bkj
public class TaskSet01_11 {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		
		int p = kb.nextInt();
		int q = kb.nextInt();
		
		int [][] aMatrix = new int[p][q];
		
		for (int i = 0; i < aMatrix.length; i++) {
			for (int j = 0; j < aMatrix[i].length; j++) {
				aMatrix[i][j] = kb.nextInt();
			}
		}

		q = kb.nextInt();
		int r = kb.nextInt();
		
		int [][] bMatrix = new int[q][r];
		
		for (int i = 0; i < bMatrix.length; i++) {
			for (int j = 0; j < bMatrix[i].length; j++) {
				bMatrix[i][j] = kb.nextInt();
			}
		}
		
		kb.close();
		
		int [][] cMatrix = new int[p][r];
		
		for (int i = 0; i < p; i++) {
			for (int j = 0; j < r; j++) {
				for (int k = 0; k < q; k++) {
					cMatrix[i][j] = cMatrix[i][j] + (aMatrix[i][k] * bMatrix[k][j]);
				}
			}
		}
		
		for (int i = 0; i < cMatrix.length; i++) {
			for (int j = 0; j < cMatrix[i].length; j++) {
				System.out.print(cMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
