import java.util.Scanner;

public class Sol1012 {

	static int T;

	static int M; // 가로

	static int N; // 세로

	static int K;

	static int map[][];

	static boolean visited[][];

	static int dy[] = { -1, 0, 1, 0 };

	static int dx[] = { 0, 1, 0, -1 }; // 북동남서

	static void dfs(int y, int x) {

		int nextY;

		int nextX;

		visited[y][x] = true;

		for (int i = 0; i < 4; i++) {

			nextY = y + dy[i];

			nextX = x + dx[i];

			if (isPossible(nextY, nextX)) {

				dfs(nextY, nextX);

			}

		}

	}

	static boolean isPossible(int y, int x) {

		if (y >= 0 && y < N && x < M && x >= 0) {

			if (map[y][x] == 1 && visited[y][x] == false) {

				return true;

			}

		}

		return false;

	}

	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);

		T = scan.nextInt();

		for (int tc = 0; tc < T; tc++) {

			M = scan.nextInt();

			N = scan.nextInt();

			K = scan.nextInt();

			map = new int[N][M];

			visited = new boolean[N][M];

			int x;

			int y;

			for (int i = 0; i < K; i++) {

				x = scan.nextInt();

				y = scan.nextInt();

				map[y][x] = 1;

			}

			int result = 0;

			for (int i = 0; i < N; i++) {

				for (int j = 0; j < M; j++) {

					if (map[i][j] == 1 && visited[i][j] == false) {



						result++;

						dfs(i, j);

					}

				}

			}

			System.out.println(result);

		}

	}

}
