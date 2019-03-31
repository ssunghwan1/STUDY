import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol7576 {
	static class Loc {
		int x;
		int y;
		public Loc(int y, int x) {
			this.x= x;
			this.y =y;
		}
	}
	static int M;//x
	static int N;//y
	static int map[][];
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int Tomato() {		
		Loc location;
		int result=0;
		Queue<Loc> loc =new LinkedList<>();
		int ny;
		int nx;
		for(int i=0; i< N ; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) {
					loc.offer(new Loc(i,j));
				}
			}
		}
		
		while(!loc.isEmpty()) {
/*			for(int i=0; i< N ; i++) {
				for(int j=0; j<M; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
				
				
			}
			System.out.println("------------------");*/
			location = loc.poll();
			for(int i=0; i<4; i++) {
				ny = location.y + dy[i];
				nx = location.x + dx[i];
				if(rangeChk(ny, nx) && map[ny][nx] == 0) {
					map[ny][nx] =map[location.y][location.x] + 1;
					loc.offer(new Loc(ny,nx));
					result =map[ny][nx];
				}				
			}
		}	
		return result;
	}
	static boolean rangeChk(int y, int x) {
		if(y >= 0 && x>=0 &&y <N && x<M && (map[y][x] !=-1)) {
			return true;
		}		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		M = scan.nextInt();
		N = scan.nextInt();
		map = new int[N][M];
	
		for(int i=0; i< N ; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = scan.nextInt();
			}
		}
				
		int result =0;
		
		result = Tomato()-1;				
		if(result == -1) {
			result = 0;
		}
		
		for(int i=0; i< N ; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					result = -1;
				}
			}
			
		}		
		System.out.println(result);
	}

}
