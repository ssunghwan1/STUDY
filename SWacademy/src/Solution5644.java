/*import java.util.Scanner;

public class Solution5644 {
	static class BC{
		int y,x,c,p;
		public BC(int y, int x, int c, int p) {
			this.y = y;
			this.x = x;
			this.c = c;
			this.p = p;
		}
	}
	static int T;
	static int M; //이동시간
	static int A; //BC의 개수
	static int moveInfo[][];
	static int loc[][];
	static BC ap[];
	static int y,x,c,p;
	static int result;
	static int dy[][]= {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for(int tc = 1; tc <= 1; tc++) {
			M = scan.nextInt();
			A = scan.nextInt();
			moveInfo = new int[2][M];
			ap = new BC[A];
			for(int j=0; j<2; j++) {
				for(int i=0; i<M; i++) {
					moveInfo[j][i] = scan.nextInt();
				}
			}
			for(int i=0;i<A; i++) {
				y = scan.nextInt();
				x = scan.nextInt();
				c = scan.nextInt();
				p = scan.nextInt();
				ap[i] = new BC(y, x, c, p);
			}		
			loc = new int[2][2];
			loc[0][0] =0 ;//y
			loc[0][1] =0 ;//x
			loc[1][0] =9 ;//y2
			loc[1][1] =9 ;//x2
			for(int i=0; i<M; i++) {
				
				moveInfo[0][i];
				moveInfo[1][i];
				result=calCharge(result);
			}
			
		}
	}
	static int calCharge(int point) {
		int result=0;
		
		
		point += result;
		return point;
	}

}
*/