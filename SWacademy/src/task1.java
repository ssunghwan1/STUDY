import java.util.ArrayList;
import java.util.Scanner;

public class task1 {

	public static void main(String[] args) {	
		task1 a = new task1();
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int reuslt = a.solution(N);
		System.out.println("reuslt " +reuslt );

	}
	public int solution(int N) {
		int tmpResult =0;
		int result = 0;
		int tmp =0;
		int binaryChar;
		ArrayList<Integer> arrBinary = new ArrayList<>(); 
		while(N>0) {
			tmp=N/2;
			binaryChar = N - tmp*2;
			arrBinary.add(binaryChar);
			N=tmp;			
		}		
/*		
		for(int i= arrBinary.size()-1 ; i>=0; i--) {
			System.out.print(arrBinary.get(i));		
		}*/
		for(int i= arrBinary.size()-2 ; i>=0; i--) {			
			if(arrBinary.get(i)==0) {
				tmpResult++;
			}else {
				if(result < tmpResult) {
					result = tmpResult;
				}
				tmpResult=0;
			}
			
			
		}
		
		return result;
	}

}
