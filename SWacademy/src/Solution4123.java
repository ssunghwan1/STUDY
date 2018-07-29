import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/*
 *
1sdfds
6
4 1 0 0
1 2 3 4 5 6 */
//8
//숫자 만들기
public class Solution4123 {
	static int maxResult;
	static int minResult;
	static int tmpResult;
	static int getResult(Stack<Character> cals, int[] numbers) {
		int result =numbers[0];
		ArrayList<Character> calArr = new ArrayList<>();
		for(int i=0; i <cals.size() ; i++) {			
			if(cals.get(i)  == '+') {
				result = result + numbers[i+1];
			}else if(cals.get(i) == '-') {
				result = result - numbers[i+1];
			}else if(cals.get(i) == '*') {
				result = result * numbers[i+1];
			}else if(cals.get(i) == '/') {
				result = result / numbers[i+1];
			}
		}
		return result;
	}
	
	
	static int setCals(Stack<Character> cals , int[] calNums, int[] numbers) {
		if(calNums[0]==0 && calNums[1]==0 && calNums[2]==0 && calNums[3]==0) {
			tmpResult = getResult(cals,numbers);
			if(tmpResult > maxResult) {
				maxResult = tmpResult;
			}
			if(tmpResult <= minResult) {
				minResult = tmpResult;
			}
			return 0;
		}
		
		for(int i=0; i< 4; i++) {
			if(calNums[i] > 0) { //남아있는 기호가 있어야함				
				if(i == 0) {
					cals.push('+');	
				}else if(i == 1) {
					cals.push('-');
				}else if(i == 2) {
					cals.push('*');
				}else if(i == 3) {
					cals.push('/');
				}			
				calNums[i] --;
				setCals(cals, calNums, numbers);
				cals.pop();
				calNums[i] ++;
			}
		}
		return 0;
	}
	
	
	
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int Test_case = scan.nextInt();
		int N; //입력받는 숫자 갯수
	
		Stack<Character> cals = new Stack<>();
		
		for(int tc=1; tc <=Test_case ; tc++) {
			maxResult = -987654321;
			minResult = 987654321;
			N = scan.nextInt();
			int[] calnums = new int[4];  //  + - * /
			int[] numbers = new int[N];
			for(int i=0; i< 4 ; i++) {
				//기호 입력
				calnums[i] = scan.nextInt(); 
			}
			for(int i = 0 ; i< N; i++ ) {
				numbers[i] = scan.nextInt();
			}
			setCals(cals, calnums, numbers);
			System.out.println("#" + tc +" " + (maxResult- minResult));
		}
	}

}
