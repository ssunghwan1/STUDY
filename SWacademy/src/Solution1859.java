import java.util.Arrays;
import java.util.Scanner;

//백만장자 프로젝트
public class Solution1859 {
	static int T, N;
	static int priceArr[] = new int[1000000];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for(int tc =0 ; tc<T ; tc++) {
			N = scan.nextInt();
			Arrays.fill(priceArr, 0);
			for(int i=0; i<N; i++) {
				priceArr[i] = scan.nextInt();
			}
			// alogirithm startg
			// 내림차순 정렬될 배열 ㄱㄱ
			// 최댓값을 찾는다
			// 최댓값 이전 모든 것들은 구매 후 최댓값일 때 판매한다.
			// 2번재 큰값을 찾는다 위치파악
			// 최댓값 이후의 것들 중 최댓값을 구한다
			// 반복
			
		}
	}

}
