import java.util.Scanner;

//https://www.swexpertacademy.com/main/learn/course/lectureProblemViewer.do
//숫자 만들기
public class Solution1210 {
	static int T;
	static int map[][];
	static int endPoint;
	static int startPoint;
	static int Answer;
	static int direction[][] = {{ 1, 0 }, { 0, 1 }, { 0, -1 }};// 아래 오른쪽 왼쪽

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {			
			T = scan.nextInt();
			map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = scan.nextInt();
					if (map[i][j] == 2) {
						endPoint = j;
					}
				}
			}
			Answer = getResult(map);
			System.out.println("#" + tc +" " + Answer);
		}

	}

	// 끝까지 가는걸 계산함
	static int getEndPoint(int y, int x, int direction) {
		if(y==99) return x; //x좌표 반환
		
		if(direction==0) {			
			if(x+1 < 100 && map[y][x+1] == 1) {
				direction = 1; 
				return getEndPoint(y,x+1,direction);
			}else if(x - 1 >= 0 && map[y][x-1] == 1) {
				direction = 2;
				return getEndPoint(y, x-1, direction);
			}else return getEndPoint(y+1, x, direction);
		}else if(direction ==1) {
			if(x+1 < 100 && map[y][x+1] == 1) {
				return getEndPoint(y, x+1, direction);
			}else {
				direction = 0;
				return getEndPoint(y+1, x, direction);
			}
		}else if(direction ==2) {
			if(x-1 >= 0 && map[y][x-1] == 1) {
				return getEndPoint(y, x-1, direction);
			}else {
				direction = 0;
				return getEndPoint(y+1, x, direction);
			}
		}
		
		return 99999;
	}

	// 값을 구함
	static int getResult(int map[][]) {
		int x = 0;
		int end;
		for (int i = 0; i < 100; i++) {
			if (map[0][i] == 1 && getEndPoint(0,i,0) == endPoint) {
				x = i;
			}
		}
		return x;
	}

}
