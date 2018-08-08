import java.util.ArrayList;
import java.util.Scanner;
/*
1
1 1 1 1
1 1 1 2
1 1 2 1
1 1 1 1
 */
public class Solution2819 {
	static int T;
	static int map[][] = new int[4][4];
	static int Answer;
	static ArrayList<String> numLists;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T= scan.nextInt();
		
		
		for(int tc =1; tc<=T ; tc++) {
			numLists =  new ArrayList<>();
			for(int i=0; i< 4; i++) {
				for(int j=0; j<4; j++) {
					map[i][j] = scan.nextInt();
				}
			}
			Answer = getResult();
			System.out.println(Answer);

		}
	}
	static int getResult() {
		int result=0;
		
		for(int i=0; i< 4; i++) {
			for(int j=0; j<4; j++) {
				result += sovle( i, j, "");
			}
		}
		return result;
	}
	static int sovle(int y, int x, String input) {
		input += Integer.toString(map[y][x]);
		int result = 0;
		
		if(input.length() == 6) {
			if(chkResult(input)) {
				return 1;
			}else {
				return 0;
			}
		}
		
		
		//µ¿
		System.out.println(input);
		if(canGo(y,x+1)) {
			result = sovle(y,x+1, input);
			input = input.substring(0, input.length() -1);
		}
		//¼­
		if(canGo(y,x-1)) {
			sovle(y,x-1, input);
			input = input.substring(0, input.length() -1);
		}
		/*
		//³²
		if(canGo(y+1,x)) {
			sovle(y+1,x, input);
			input = input.substring(0, input.length() -1);
		}
		//ºÏ
		if(canGo(y-1,x)) {
			sovle(y-1,x, input);
			input = input.substring(0, input.length() -1);
		}
		*/
		return result;
	}
	static boolean canGo(int y, int x) {
		if(y>=0 && x>=0 && y<4 && x< 4) {
			return true;
		}else {
			return false;
		}
	}
	static boolean chkResult(String input) {
		boolean flag = true;
		for(int i=0; i< numLists.size() ; i++) {
			if(numLists.get(i).equals(input)) {
				flag = false;
				return flag;
			}
		}
		if(flag == true) {
			numLists.add(input);
		}
		
		return flag;
	}
	

	
	
	
	
	
}






















