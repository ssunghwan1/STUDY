import java.util.Scanner;

public class Solution2817 {
	static int T;
	static int N, K;
	static int numbers[];
	static int Answer;
	
	static int solve(int start, int psum, int num){
		psum += numbers[start];
		if(psum > K ) return num;
		if(psum == K ){
			num++;
		}
		for(int i=1; i<N - start; i++){
			num = solve(start+i , psum , num);
		}
		
		return num;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		
		
		for (int tc = 1; tc <= T; tc++) {
			numbers = new int[100];
			Answer= 0;
			N = scan.nextInt();
			K = scan.nextInt();
			
			for(int i=0; i<N; i++){
				numbers[i] = scan.nextInt();
			}			
			for(int i=0; i< N; i++){
				Answer += solve(i,0,0);
			}			
			System.out.println("#" + tc +" " + Answer);
		}
	}

}
