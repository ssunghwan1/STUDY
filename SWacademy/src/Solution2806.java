import java.util.Scanner;
 
public class Solution2806 {
    static int cnt = 0, N = 0, T = 0;
    static int arr[];
      
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	T = scan.nextInt();
    	for(int tc= 1 ; tc <= T ; tc++) {
    		cnt = 0;
    		N = scan.nextInt();
    		arr = new int[N];
    		getResult(arr, 0);
    		System.out.println("#" + tc + " " + cnt);
    	}
    
    }
    public static void getResult(int arr[], int y) {
   
    	if(y == N) {
    		cnt++;
    		return ;
    	}    	
    	
    	for(int i=0; i< N ; i++) {
    		arr[y] = i;
    		if(canGo(arr, y)) getResult(arr, y+1);
    	}
    }
    
    public static boolean canGo(int arr[], int y) {
     	for(int i = 0; i < y; i++) {
    		if(arr[i] ==  arr[y] ||
    			((arr[i]- arr[y])==(y-i)) ||
    			((arr[i]- arr[y])==(i-y))) 
    		{
    			
    			return false;
    		}
    	}
     	return true;
    }
}