import java.util.Arrays;
import java.util.Scanner;

//�鸸���� ������Ʈ
public class Solution1859 {
	static int T, N;
	static int priceArr[] = new int[1000000];
	static int sortedPriceArr[];
	static int Answer;
	static int getMaxIndex(int max, int maxIndex) {
		for(int i=maxIndex; i< N; i++) {
			if(priceArr[i] == max) {
				return i;
			}
		}
		return maxIndex;
	}
	static int getResult() {
		int max;
		int maxIndex =0;
		int tmpMaxIndex =0 ;
		int result =0;
		for(int i=N-1; i>= 0;i++) {
			max = sortedPriceArr[i];
			tmpMaxIndex = getMaxIndex(max, maxIndex);
			if(maxIndex != tmpMaxIndex) {
				for(int j=maxIndex; j< tmpMaxIndex; j++) {
					result += priceArr[tmpMaxIndex] - priceArr[j];  
				}
			}
		}
		return result;
		
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for(int tc =0 ; tc<T ; tc++) {
			N = scan.nextInt();
			Arrays.fill(priceArr, 0);
			for(int i=0; i<N; i++) {
				priceArr[i] = scan.nextInt();
			}
			sortedPriceArr = priceArr;
			Arrays.sort(sortedPriceArr);
			Answer = getResult();
			System.out.println("#"+tc+" " +Answer);
			
			// �������� ���ĵ� �迭 ����
			// �ִ��� ã�´�
			// �ִ� ���� ��� �͵��� ���� �� �ִ��� �� �Ǹ��Ѵ�.
			// 2���� ū���� ã�´� ��ġ�ľ�
			// �ִ� ������ �͵� �� �ִ��� ���Ѵ�
			// �ݺ�
			
		}
	}

}
