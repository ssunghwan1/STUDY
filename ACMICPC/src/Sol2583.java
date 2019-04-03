import java.util.*;
public class Sol2583 {
	static int M; //세로
	static int N; //가로
	static int K; //직사각형 갯수
	static int y1,y2,x1,x2;
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int map[][];
	
	public static void makeInputLect(int x1,int y1, int x2, int y2) {
		for(int i=y1; i<y2;i++) {
			for(int j=x1; j<x2; j++) {
				map[i][j] = 1;
			}
		}
	}
	public static int dfs(int y, int x) {
		int count = 1;
		map[y][x] = 1;
		int nextY;
		int nextX;
		
		for(int i=0 ;i<4; i++) {
			nextY = y + dy[i];
			nextX = x + dx[i];	
			if(isInbound(nextY,nextX)) {
				count  += dfs(nextY, nextX);
			}
		}
		return count;
	}
	public static boolean isInbound(int y, int x){
		if(y >= 0 && x>=0 && y<M && x<N && map[y][x] == 0) {
			return true;
		}
		
		return false;
	}
	public static void print() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int result =0;
		ArrayList<Integer> arr = new ArrayList<>();
		M = scan.nextInt();
		N = scan.nextInt();
		K = scan.nextInt();
		
		map = new int [M][N];
		
		for(int i=0; i< K; i++) {
			x1 = scan.nextInt();
			y1 = scan.nextInt();
			x2 = scan.nextInt();
			y2 = scan.nextInt();			
			makeInputLect(x1,y1,x2,y2);
		}		
		for(int i=0; i<M;i++) {
			for(int j=0 ; j<N; j++) {
				if(map[i][j]==0) {					
					//System.out.println(" y : " + i + " x " + j );
					int tmp = dfs(i,j);
					arr.add(tmp);
					result++;				
				}
			}			
		}
		
		
		System.out.println(result);
		Collections.sort(arr);
		for(int i=0 ;i< arr.size(); i++) {
			System.out.print(arr.get(i) + " ");			
		}
		

		
		
		
	}

}
