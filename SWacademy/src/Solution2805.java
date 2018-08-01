import java.util.Scanner;
/*
1
5
14054
44250
02032
51204
52212
 */
public class Solution2805 {
	static int T;
	static int map[][];
	static int N;
	static int Answer;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		String inputTmp;
		for (int tc = 1; tc <= T; tc++) {
			N = scan.nextInt();
			map = new int[N][N];
			inputTmp = scan.nextLine();
			for(int i=0; i<N; i++) {
				inputTmp = scan.nextLine();
				for(int j = 0 ; j< N ; j++) {
					map[i][j] = (int)inputTmp.charAt(j) - (int)'0';
				}
			}
			getResult();

			
		}

	}
	
	static void getResult() {
		int sum = getSumall();
		int noneBenefit = getNoneBenefit();
		
		Answer = sum - noneBenefit;
	}
	
	static int getSumall() {
		int sum = 0 ;
		for(int i=0; i< N ; i++) {
			for(int j=0; j< N ; j++) {
				sum += map[i][j]; 
			}
		}
		return sum;
	}
	
	static int getNoneBenefit() {
		int sum = 0;
		int len = N/2;
		//왼쪽 위
		for(int i=0; i< len ; i++) {
			for(int j=0; j<=i ;j++) {
				sum += map[i-j][j];
			}
		}
		//왼쪽 아래 부터 해야함
		for(int i=0; i< len ; i++) {
			for(int j=0; j<=i ;j++) {
				sum += map[i-j][j];
			}
		}
		
		//오른쪽 위
		
		//오른쪽 아래
		return sum;
	}
	
}











































