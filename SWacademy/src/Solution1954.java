import java.util.Scanner;

public class Solution1954 {
	static class Location{
		int y;
		int x;
		public Location(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int T,N;
	static int map[][];
	static int endNum;
	static int tmp,dtmp;
	static int x,y;
	static int dy[]  ={0,1,0,-1};
	static int dx[]  ={1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for(int tc=1; tc<=T; tc++){
			
			N = scan.nextInt();
			map  = new int[N][N];
			tmp = 1;
			endNum = N*N;
			dtmp=0;
			//Location LC = new Location(0, 0);
			y= 0;
			x= 0;
			map[y][x] =  tmp++;
			
			while(tmp <= endNum ){
				
				if((y+dy[dtmp] < N) && (x+dx[dtmp] <N) && (y+dy[dtmp] >= 0) && (x+dx[dtmp] >=0) && (map[y+dy[dtmp]][x+dx[dtmp]] == 0)  )
				
				{ 	
					y = y+dy[dtmp];
					x = x+dx[dtmp];
			

					map[y][x] = tmp++;	
					

					
				}
				
				else{


					dtmp++;
					if(dtmp == 4 ) {
						dtmp = 0;
					}
					
				}
				
				
				
			}
			
			System.out.println("#"+tc);
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					System.out.print(map[i][j]+ " ");
				}
				System.out.println();
			}
			
			
		}
		

	}

}
