import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * ��, �׷��� ���� ���� ������ �������� ������ ��� �׷���(Sparse Graph) �� ��� ���� ��ĺ��� ���� ����Ʈ�� ����ϴ� ���� �����ϴ�.
 *
 */
public class Solution1260 {
	static ArrayList<ArrayList<Integer>> ad;
	static boolean visit[];
	static int arrad[][];
	static int N;
	static void dfs(int root) {
		System.out.print(root+ " ");
		visit[root] = true;				
		
		for(int j : ad.get(root)) {
			if(visit[j] == false) {
				dfs(j);
			}
		}			
		
		return;
	}
	static void dfs2(int root) {
		System.out.print(root + " " );
		visit[root] = true;
		
		for(int j=0; j<=N; j++) {

			if(visit[j] == false && arrad[root][j] == 1) {
				dfs2(j);
			}
		}
	}
	static void bfs1(int root) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			System.out.print(tmp+" ");
			for(int j : ad.get(tmp)) {
				if(visit[j] == false) {
					queue.offer(j);
					visit[j] = true;
				}
			}
			
		}
	}
	
	static void bfs2(int root) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(root);
		visit[root] = true;
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			System.out.print(tmp+" ");
			for(int i=0; i<arrad[0].length; i++) {
				if(arrad[tmp][i] == 1 && visit[i] == false) {
					visit[i] = true;
					queue.offer(i);
				}
			}
		}
	}
	
	public static void main(String args[]) {
		int M; //����
		int root; //������
		int vertex;
		int edge;
		
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		root =scan.nextInt();
		
		ad = new ArrayList<>();
		
		visit = new boolean[N+1];
		for(int i=0 ;i<= N; i++) {
			ad.add(new ArrayList<Integer>());
		}
		arrad = new int[N+2][N+2];
		
		for(int i=0; i< M; i++) {
			vertex = scan.nextInt();
			edge = scan.nextInt();
			ad.get(vertex).add(edge);
			
			arrad[vertex][edge] = arrad[edge][vertex]=1;
		}
		
		dfs2(root);
		System.out.println();		
		
		visit = new boolean[N+1];
		bfs2(root);
				

	}
}
