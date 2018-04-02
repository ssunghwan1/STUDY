
/*
 * https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V4A46AdIDFAWu


*
*4 3 12
8 8 6 5
5 2 7 4
8 5 1 7
7 8 9 4
*/
import java.util.Scanner;

public class Solution2115 {
	static class dfsyx {
		int y;
		int x;
	}

	static int T;
	static int N;  //맵 크기
	static int M; // 벌통의 수
	static int C; // 꿀을 채취할 수 있는 최대 양
	static int map[][];
	static int amount[][];
	static int visit[][];
	static int result;
	static int totalAmount;
	static int curAmount1;
	static int curAmount2;
	static int maxM1;
	static int count = 0;
	static int max(int a, int b){
		if(a>b){
			return a;
		}else return b;
	}
	
	static int dfs(int y, int x, int last, int result) {
		count++;
		int tmp=0;
		int curAmount1 = 0;
		int dfsresult =0;
		if(x >last) return tmp;
		if (curAmount1 + map[y][x] <= C) {
			curAmount1 += map[y][x];
			tmp += map[y][x] * map[y][x];
			for(int i = x+1; i<=last; i++){
				result= max(result, dfs(y,i, last,result));
			}
		}
		else{
			return tmp;
		}
		return tmp;
	}
	
	static void selectBox(){
		int subresult1 = 0;
		int subresult2;
		for(int i=0; i<N; i++){
			for(int j=0; j<=N-M; j++){ //박스 시작점을 고른다
				for(int i2=i+1; i2<N; i2++){
					for(int j2= 0 ; j2<N-M; j2++){
							//subresult1 = dfs(i,j,0,0,0,0);
							//subresult2 = dfs(i2,j2,0,0,0,0);
							if(result < subresult1) result = subresult1; 
					}
				}
			}
		}
		
		//같은 줄에 있는건 따로
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int tmpResult1;
			int tmpResult2 = 0;
			result = 0;
			N = scan.nextInt();
			M = scan.nextInt();
			C = scan.nextInt();
			map = new int[N][N];
			amount = new int[N][N];
			visit = new int[N][N];
			result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = scan.nextInt();
				}
			}

		/*	for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int i2 = 0; i2 < N; i2++) {
						for (int j2 = 0; j2 < N; j2++) {
							visit = new int[N][N];
							tmpResult1 = cal(i, j, 0, 0);
							if (visit[i2][j2] != 1 && j2 + M <= N) {
								tmpResult2 = cal(i2, j2, 0, 0);
							}
							if (result < tmpResult1 + tmpResult2)
								result = tmpResult1 + tmpResult2;
							if (tmpResult1 + tmpResult2 > 100) {
								System.out.println("-----------------");
								System.out.print(i + " ");
								System.out.println(j);
								System.out.print(i2 + " ");
								System.out.println(j2);
								System.out.println(tmpResult1);
								System.out.println(tmpResult2);
							}
						}
					}
				}
			}*/
		   result = dfs(3,1,3 ,0);
			System.out.println("#" + tc + " " + result);
			System.out.println(count);
		}

	}

}
