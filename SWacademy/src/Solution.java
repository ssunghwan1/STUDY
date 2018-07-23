import java.util.Scanner;

public class Solution {
	public int solution(int[] numbers) {
		int tmpResult;
		int answer = 0;
		String str = null;
		double minTmpResult = 987654321;
		boolean isSame = false;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (numbers[i] == numbers[j]) {
					if (i != j) {
						isSame = true;
					}
				}
			}
		}
		if (numbers.length < 3) {
			return -1;
		} else if (isSame == true) {
			return -2;
		}

		for (int i = 0; i < numbers.length; i++) { // 100의자리
			for (int j = 0; j < numbers.length; j++) { // 10의자리
				for (int k = 0; k < numbers.length; k++) { // 1의자리
					tmpResult = numbers[i] * 100 + numbers[j] * 10 + numbers[k];
					if (tmpResult >= 100) {
						double tmp = (double) (tmpResult / 7.0);
						System.out.println(tmp);
						if (tmp < minTmpResult) {
							minTmpResult = tmp;
						}
						str = Double.toString(minTmpResult);
					}
				}
			}
		}

		int num = str.indexOf('.');
		answer = Integer.parseInt(str.valueOf(num + 1));
		return answer;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int arr[] = { 0, 1, 2, 3, 4 };
		sol.solution(arr);
	}
}