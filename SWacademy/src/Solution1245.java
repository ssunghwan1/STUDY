//https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15MeBKAOgCFAYD&categoryId=AV15MeBKAOgCFAYD&categoryType=CODE&&&
import java.util.Scanner;

public class Solution1245 {
	static int T;
	static int N; // �ڼ�ü�� ����
	static int LocationArr[]; // ��ġ ���
	static int mArr[]; // ����

	static double getF(double d) {
		double F;
		
		//m1, m2, G �� �����
		F = d * d;
		return F;
	}

/*	static double getAnswer(int[] LocationArr, int[] mArr){
		int Answer, curX, nextX;
	
		return Answer;
	}*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = scan.nextInt();
			LocationArr = new int[N];
			mArr = new int[N];
			for (int i = 0; i < N; i++) {
				LocationArr[i] = scan.nextInt();
			}
			for (int i = 0; i < N; i++) {
				mArr[i] = scan.nextInt();
			}
			
			
			
			
		}
		scan.close();

	}

}
