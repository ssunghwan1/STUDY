//https://www.swexpertacademy.com/main/learn/course/lectureProblemViewer.do
import java.util.Scanner;

public class Solution1247 {
	static class Location{
		int y,x;
	}
	
	static int T;
	static int N; //���� ��
	static Location location[];
	static boolean visited[];
	static int result;
	
	static int getDistance(Location loc){
		return 0;
	}
	
	static void calc(int num, boolean visited[], int distance ){
		if(num == N-1) {
			Math.min(result, distance);
			return;
		}
		
		visited[num] = true;
		//�Ÿ����
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for(int tc=1; tc<=T ; tc++){
			N = scan.nextInt();
			//ù��° ȸ���� ��ǥ, �ι�° ������ǥ
			location = new Location[N+2];
			visited = new boolean[N+2];
			for(int i= 0; i< N+2;  i++){
				location[i] = new Location();
				location[i].x = scan.nextInt();
				location[i].y = scan.nextInt();
			}
			
			calc(0, visited, 0);
			
		}
		

	}

}
