import java.util.Scanner;

public class Solution1207 {
	static int TestCase;
	
	
	static int solve(int[][] map) {
		int Max=0;
		int tmpResult = 0 ;
		//가로		
		for(int i=0; i< 100; i++) {
			tmpResult = 0 ;
			for(int j=0; j< 100; j++) {
				tmpResult += map[i][j];
			}
			Max = Max > tmpResult ? Max : tmpResult;
		}
		//세로
		for(int i=0; i< 100; i++) {
			tmpResult = 0 ;
			for(int j=0; j< 100; j++) {
				tmpResult += map[j][i];
			}
			Max = Max > tmpResult ? Max : tmpResult;
		}
		//대각 오른쪽 아래로
		tmpResult = 0 ;
		for(int i=0; i< 100; i++) {
			tmpResult += map[i][i];
			Max = Max > tmpResult ? Max : tmpResult;
		}
		//대각 왼쪽 아래로
		tmpResult = 0 ;
		for(int i=0; i< 100; i++) {
			tmpResult += map[99-i][99-i];
			Max = Max > tmpResult ? Max : tmpResult;
		}

		return Max;
	}	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int Answer;
		for(int tc=1; tc<=10; tc++) {
			int map[][] = new int[100][100];
			
			TestCase = scan.nextInt();
			for(int i=0; i< 100; i++) {
				for(int j=0; j<100 ; j++) {
					map[i][j] = scan.nextInt();
				}
			}
			
			Answer = solve(map);
			
			System.out.println("#" + tc +" " + Answer);
			
		}

	}

}
