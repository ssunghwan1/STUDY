import java.util.ArrayList;
import java.util.Scanner;

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
		
		if(input.length() == 6) {
			if(chkResult(input)) {
				return 1;
			}else {
				return 0;
			}
		}
		
		int result = 0;
		//µ¿
		if(canGo(x+1,y)) {
			sovle(x+1,y, input);
		}
		input = input.substring(0, input.length() -1);
		//¼­
		if(canGo(x-1,y)) {
			sovle(x-1,y, input);
		}
		input = input.substring(0, input.length() -1);
		//³²
		if(canGo(x,y+1)) {
			sovle(x,y+1, input);
		}
		input = input.substring(0, input.length() -1);
		//ºÏ
		if(canGo(x,y-1)) {
			sovle(x,y-1, input);
		}

		
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






















