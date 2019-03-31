import java.util.*;

public class Sol11403 {
	static int map[][];
	static int resultMap[][];
	static boolean visited[];
	static int N;
	public static void bfs(int y) {
		visited = new boolean[N];
		Queue<Integer> q = new LinkedList<>();
		q.add(y);		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i=0; i< N; i++) {
				if(map[tmp][i] == 1 && visited[i] == false) {
					q.add(i);
					visited[i] = true;
					resultMap[y][i] = 1;
				}
					
			}
		}
		
		
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		map = new int[N][N];
		resultMap = new int[N][N];
		//입력 받기
		for(int i=0 ;i< N; i++) {
			for(int j=0; j< N; j++) {
				map[i][j] = scan.nextInt();
				//resultMap[i][j] = map[i][j];
			}
		}
		for(int i=0 ;i< N; i++) {
			bfs(i);
		}
		for(int i=0 ;i< N; i++) {
			for(int j=0; j< N; j++) {
				System.out.print(resultMap[i][j] + " " );
			}
			System.out.println();
		}
		
		
		
	}

}
