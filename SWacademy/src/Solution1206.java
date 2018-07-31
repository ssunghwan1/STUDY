import java.util.Scanner;

public class Solution1206 {
	static int N;
	static int buildingArr[];
	static int Answer;
	static int getMax(int x) {
		int max = 0;
		
		max = buildingArr[x-2] > max ? buildingArr[x-2] :max;
		max = buildingArr[x-1] > max ? buildingArr[x-1] :max;
		max = buildingArr[x+1] > max ? buildingArr[x+1] :max;
		max = buildingArr[x+2] > max ? buildingArr[x+2] :max;
		
		return max;
	}
	static int getResult() {
		int max =0;
		int result=0;
		// 앞에 2 뒤에 2개 비어있음
		for(int i=2; i< N-3; i++) {			
			max = getMax(i);
			if(buildingArr[i]-max > 0) {
				result += buildingArr[i]-max;
			}
		}
		
		return result;
		
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for(int tc=1; tc <= 10 ; tc++) {
			N = scan.nextInt();
			buildingArr = new int[N];
			for(int i=0; i< N; i++) {
				buildingArr[i]= scan.nextInt();
			}
			Answer = getResult();
			System.out.println("#" + tc + " " + Answer);
		}

	}

}
