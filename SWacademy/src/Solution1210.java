import java.util.Scanner;

//https://www.swexpertacademy.com/main/learn/course/lectureProblemViewer.do
//���� �����
public class Solution1210 {
	static int T;
	static int map[][];
	static int endPoint;
	static int startPoint;
	static int Answer;
	static int direction[][] = {{ 1, 0 }, { 0, 1 }, { 0, -1 }};// �Ʒ� ������ ����

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

	// ������ ���°� �����
	static int getEndPoint(int y, int x, int direction) {
		if(y==99) return x; //x��ǥ ��ȯ
		
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

	// ���� ����
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
