import java.util.Scanner;

public class Solution1206 {
	static int N;
	static int buildingArr[];
	static int Answer;
	static void getResult() {
		// 앞에 2 뒤에 2개 비어있음
		for(int i=2; i< N-3; i++) {			
		
			//기준값 - 양쪽 2칸의 MAX -> 해당 빌딩 조망권 갯수
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for(int tc=1; tc <= 10 ; tc++) {
			N = scan.nextInt();
			buildingArr = new int[N];
			for(int i=0; i< N; i++) {
				buildingArr[i]= scan.nextInt();
			}
			getResult();
			System.out.println("#" + tc + " " + Answer);
		}

	}

}
