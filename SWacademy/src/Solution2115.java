/*https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V4A46AdIDFAWu
*/
import java.util.Scanner;

public class Solution2115 {
	static int T;
	static int N;
	static int M;
	static int C;
	static int map[][];
	static int amount[][];
	static int visit[][];
	static int result;

	static void cal(int y1, int x1, int y2, int x2){
		int curResult;
		int maxM1 = N-x1-1;
		int maxM2 = N-x2-1;
		int totalAmount = 0; 
		int curAmount1=map[y1][x1];
		
		//첫번째
			for(int i= 0 ; i< M; i++){ //벌꿀 최대량 구하기
				if(i>maxM1) break; //범위를 초과하면 break
				if(curAmount1+map[y1][x1+i] <=C){ // 최대 담을 수 있는 양보다 작으면
					curAmount1 +=map[y1][x1+i];
					visit[y1][x1+i] = 1;
					totalAmount+= map[y1][x1+i]*map[y1][x1+i];
				}else break;
			}
		//두번째
			/*if(visit[y2][x2]) {
				int curAmount2 = map[y2][x2];
				for(int i=0; i<M ; i++) {
					if(i>maxM2) break;					
				}
				
			}*/
		
		
		
	}
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = scan.nextInt();
			M = scan.nextInt();
			C = scan.nextInt();
			map = new int[N][N];
			amount = new int[N][N];
			visit = new int[N][N];
			result =0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = scan.nextInt();
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int i2 = 0; i2 < N; i2++) {
						for (int j2 = 0; j2 < N; j2++) {

						}
					}
				}
			}

		}

	}

}
