import java.util.Scanner;

public class Solution1206 {
	static int N;
	static int buildingArr[];
	static int Answer;
	static void getResult() {
		// �տ� 2 �ڿ� 2�� �������
		for(int i=2; i< N-3; i++) {			
		
			//���ذ� - ���� 2ĭ�� MAX -> �ش� ���� ������ ����
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for(int tc=1; tc <= 10 ; tc++) {
			N = scan.nextInt();
			buildingArr = new int[N];
			for(int i=0; i< N; i++) {
				buildingArr[i]= scan.nextInt();
			}
			getResult();
			System.out.println("#" + tc + " " + Answer);
		}

	}

}
