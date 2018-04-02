import java.util.Scanner;

public class Solution2112 {
	static int T;
	static int D; // �β�
	static int W; // ����ũ��
	static int K; // �հݱ���
	static int map[][];
	static int answer;
	static boolean isPass(int map[][]) { //�հ��̸� true �ƴϸ� false
		int Dpass[] = new int[W];
		for (int j = 0; j < W; j++) { // ����
			for (int i = 0; i < D-2; i++) {
				if(map[i][j] == map[i+1][j] && map[i+1][j] == map[i+2][j] ) 
					{	Dpass[j] = 1; 
						break;
					}
			}
		}
		for(int i=0; i< W ; i++){
			if(Dpass[i] == 0) return false;
		}
		return true;
	}
	
	static int[][] Injection(int map[][] , int y, int phill){
		for(int i=0;  i< W ; i++ ){
			map[y][i] = phill;
		}
		return map;
		
	}
	
	static int solve(int map[][], int count, int y , int result){
		if(isPass(map)) {
			System.out.println(">>>>>>>>" + count);
			return count;
		}
		if(y == D ) return D;

		for(int i=y+1 ;i< D-1 ; i++){
			for(int j= 0; j<2; j++){
				int tmp[][] = Injection(map, i, j);
				
				int counttmp= solve(tmp, count+1, i,result);
				result = Math.min(counttmp, result);
			}
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			D = scan.nextInt();
			W = scan.nextInt();
			K = scan.nextInt();
			map = new int[D][W];
			answer = 987654321;
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = scan.nextInt();
				}
			}
			
			answer =solve(map,0,0,999999);

			System.out.println("#" + tc + " " + answer);
		}
	}

}
