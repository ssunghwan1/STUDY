import java.util.Scanner;

/* 1248. [S/W 문제해결 응용] 3일차 - 공통조상 */
/*
1
13 12 8 13
1 2 1 3 2 4 3 5 3 6 4 7 7 12 5 9 5 8 6 11 6 10 11 13
 */
public class Solution1248 {
	static class Tree {
		int left;
		int right;
		int root;
		public Tree() {
			this.left =0;
			this.right=0;
			this.root =0;
		}
	}

	static int V; // 정점의 총 수
	static int E; // 간선의 총 수
	static int A; // 공통 조상을 찾는 번호
	static int B; // 공통 조상을 찾는 번호
	static Tree nodes[];
	static int depth[];
	static int parent, child;
	
	static int getDaepth(int data) {
		/*nodes[data].root = 
		return 0;*/
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			V = scan.nextInt();
			E = scan.nextInt();
			A = scan.nextInt();
			B = scan.nextInt();

			nodes = new Tree[V + 1];
			depth = new int[V + 1];
			for(int i=0; i<=V ; i++) {
				Tree node = new Tree();
				nodes[i]=node;
			}
			for (int i = 0; i < E; i++) {
				parent = scan.nextInt();
				child = scan.nextInt();

				if(nodes[parent].left == 0) {
					nodes[parent].left=child;
				}else {
					nodes[parent].right=child;
				}
				nodes[child].root = parent;
				
			}
			System.out.println("#"+tc+" ");
		} ///////////////////////////////

	}

}
