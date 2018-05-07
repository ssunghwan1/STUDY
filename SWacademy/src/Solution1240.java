import java.util.Scanner;

public class Solution1240 {
	static String crypto[] = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
			"0110111", "0001011" };
	static int T;
	static String input[];
	static int N, M; // N มู
	static int start;
	static int answercheck[];
	static int tennumbers[];
	static int answer;

	static int numbercheck(int start, String input) {
		String tmp = input.substring(start, start + 7);
		
		//System.out.println("======================tmp=========");
		//System.out.println(tmp);
		return convertnumber(tmp);
	}

	static int convertnumber(String input) {
		for (int i = 0; i < 10; i++) {
			if (input.equals(crypto[i])) {
				return i;
			}
		}
		return 123456789;
	}

	static boolean isTrueCode(int[] input) {
		int tmp = (input[0] + input[2] + input[4] + input[6]) * 3 + input[1] + input[3] + input[5] + input[7];
		if (tmp % 10 == 0)
			return true;
		else
			return false;
	}

	static int startpoint(String input) {
		int min = 987654321;
		for (int i = 0; i < 10; i++) {
			int tmp = input.indexOf(crypto[i]);
			if (tmp != -1 && min > tmp) {
				min = tmp;
			}
		}
		return min;
	}

	static int getsum(int[] input) {
		
		int result = 0;
		for (int i = 0; i < 8; i++) {
			//System.out.println("===================");
		/*	System.out.println(input[i]);*/
			result += input[i];
		}
		return result;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			N = scan.nextInt();
			M = scan.nextInt();
			
			scan.nextLine();
			
			input = new String[N];
			answercheck = new int[8];
			tennumbers = new int[8];
			boolean flag = false;
			answer = 0;
			for (int i = 0; i < N; i++) {
				
				input[i] = scan.nextLine();
				if (!flag) {
					for (int j = 0; j < 10; j++) {
						if (input[i].contains(crypto[j])) {
							start = startpoint(input[i]);
							start--;
							for(int l=0; l<7; l++){
								
								start ++;
								int end = start + 49;
								int tmp = 0;
								for (int k = start; k <= end; k = k + 7) {
									tennumbers[tmp] = numbercheck(k, input[i]);
									tmp++;
								}
								if (isTrueCode(tennumbers)) {
									answer = getsum(tennumbers);
									break;
								} else
									answer = 0;
								flag =true;
							}
						}
					}
				}
			}
			System.out.println("#" + tc + " " +answer);
		}

	}

}
