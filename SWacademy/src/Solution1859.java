import java.util.Arrays;
import java.util.Scanner;
/*
1
5
1 3 1 3 1
 */
//백만장자 프로젝트
public class Solution1859 {
	static int T, N;
	static int priceArr[];
	static int sortedPriceArr[];
	static long Answer;
	static int getMaxIndex(int max, int maxIndex) {
		for(int i=N-1; i>= maxIndex; i-- ) {
			if(priceArr[i] == max) {
				return i;
			}
		}
		return maxIndex;
	}
	static long getResult() {
		int max=0;
		int maxIndex =0;
		int tmpMaxIndex =0 ;
		long result =0;
		
		for(int i=N-1; i>= 0;i--) {
			max = sortedPriceArr[i];
			tmpMaxIndex = getMaxIndex(max, maxIndex);
			/*System.out.println(tmpMaxIndex);*/
			if(maxIndex != tmpMaxIndex) {
				for(int j=maxIndex; j< tmpMaxIndex; j++) {
					if(priceArr[tmpMaxIndex] - priceArr[j] > 0) {
						result += priceArr[tmpMaxIndex] - priceArr[j];
					}
				}
				maxIndex = tmpMaxIndex;
			}
			/*System.out.println(result);*/
			
		}
		return result;
		
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for(int tc =1 ; tc<=T ; tc++) {
			N = scan.nextInt();
			priceArr = new int[N];
			sortedPriceArr = new int[N];
			for(int i=0; i<N; i++) {
				priceArr[i] = scan.nextInt();
				sortedPriceArr[i] = priceArr[i];
			}
			Arrays.sort(sortedPriceArr);
			Answer = getResult();
			System.out.println("#"+tc+" " +Answer);
			
		}
	}

}
