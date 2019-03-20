import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol1697 {
	static class Subin {
		int x;
		int time;
		int type;
		public Subin(int x, int time, int type) {
			this.x = x;
			this.time = time;
			this.type = type;
		}
	}

	static int N;
	static int K;
	static boolean visited[] = new boolean[100002];
	static void bfs(int n) {
		int time = 1;
		int x = n;
		Queue<Subin> q = new LinkedList<>();
		Subin sb;
		if(x > 0){
			q.offer(new Subin(x - 1, time,1));			
		}
		//여기 10000 0 으로 하면 런타임 뜨니까 해결하기
		
		q.offer(new Subin(x + 1, time,2));
		q.offer(new Subin(x * 2, time,3));

		
		while (!q.isEmpty()) {
			sb = q.poll();
			visited[sb.x] = true;
	
			if (sb.x == K) {
				System.out.println(sb.time);
				return;
			}
			
			if(sb.x -1 > 0 && sb.x -1 <= 100000 && visited[sb.x-1] == false ) {
				q.offer(new Subin(sb.x - 1, sb.time + 1,1));				
			}
			if(sb.x + 1> 0 && sb.x +1 <= 100000 && visited[sb.x + 1] == false ) {
				q.offer(new Subin(sb.x + 1, sb.time + 1,2));				
			}
			if(sb.x > 0 && sb.x * 2 <= 100000 &&visited[sb.x * 2] == false) {
				q.offer(new Subin(sb.x * 2, sb.time + 1,3));					
			}
		

		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		K = scan.nextInt();
		bfs(N);

	}

}
