import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Solution2383 {
	static class Person{

		int selectStair;
		int spendTime;
		int leftTime;
		public Person(int selectStair1) {
			//초기화
			this.selectStair = selectStair1;
			//마스터는 잘되겠지ㅋㅋㅋ
			//몇번째zz z테z스트z임
			//마지막이 되길
		}
	}
	static int T;
	static int N;
	static int map[][]= new int[10][10];
	static Queue<Integer> stairA;
	static Queue<Integer> stairB;
	static ArrayList<Person> arrPerson;
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T =  scan.nextInt();
		for(int test_case = 1; test_case<= T; test_case++ ){
			N = scan.nextInt();
			for(int i = 0; i< N ; i++){
				for(int j= 0 ; j< N ; j++){
					map[i][j] = scan.nextInt();					
				}
			}
			
			
			
			
			
			
			
		}
				
		
	}

}
