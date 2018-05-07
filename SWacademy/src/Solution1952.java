import java.util.Arrays;
import java.util.Scanner;

public class Solution1952 {
	
	static int T;
	static int swimming[] = new int[12]; // 수영장 가는 날수
	static int Calendar[] = new int[12]; // 월별 가격
	static int day, month, month3, year;
	static int result;
	static int visit[] = new int[12];
	static void selectOne(){
		
		for(int i=0 ; i < 12 ;i++){
			int tmp = swimming[i] ;
			Calendar[i] = Math.min(tmp*day, month);
			Calendar[i] = Math.min(Calendar[i], month3);
		}
		int tmpresult= 0;
		for(int i=0 ; i < 12 ;i++){
			tmpresult += Calendar[i];
		}
		result = Math.min(tmpresult, result);
	} 
	
	static void select3month(int start, int[] visit, int[] Calendar){
		System.out.println("!!!!!!!!!!");
		System.out.println(start);
		if(start>=12) return;
		//if(visit[start] == 1 ) return;
		visit[start] = 1;
		
		if(swimming[start] != 0 ){
			Calendar[start] = month3;
			
			for(int i=1; i< 3; i++){
				if(start +i >=12 ) continue;
				if(visit[start+i]==0){
					//visit[start+i] = 1;
					Calendar[start+i] = 0;
				}		
			}
		}
		
		int tmpresult = 0;
		for(int i=0 ; i < 12 ;i++){
			tmpresult += Calendar[i];
		}
		
		result = Math.min(result, tmpresult);
		

			for(int i= 0; i< 12; i++){
				System.out.print(Calendar[i] + " " );
			}
			System.out.println();
			 
		for(int i=1 ; i<3; i++){
			select3month(start + i, visit, Calendar);			
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		
		for(int tc=1; tc<=T ; tc++){
			Arrays.fill(swimming, 0);
			Arrays.fill(Calendar, 0);
			Arrays.fill(visit, 0);
			
			day = scan.nextInt();
			month = scan.nextInt();
			month3 = scan.nextInt();
			year = scan.nextInt();
			result = year;
			for(int i=0 ; i < 12; i++){
				swimming[i] = scan.nextInt();
			}
		
			for(int i=0 ;i < 1; i++){
				selectOne();
				Arrays.fill(visit, 0);
				select3month(i, visit, Calendar);
				//System.out.println(result);
			}
			//select3month(5, visit, Calendar);
			//result= Math.min(year,result);
			
			System.out.println("#"  + tc + " " + result );
		}

	}

}
