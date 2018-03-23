import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Solution2383 {
	static class Person{
		int selectStair;
		int spendTime;
		int leftTime;
		public Person(int selectStair) {
			this.selectStair = selectStair;
			
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
