import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
     
public class Test {
    static int n;
         
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            long sum = 0;
            int idx = n - 1;
             
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
             
            while(idx != 0) {
                for(int i = idx; i > 0; i--) {
                    if(arr[idx] >= arr[i - 1])
                        sum += arr[idx] - arr[i - 1];
                    else {
                        idx = i - 1;
                        break;
                    }
                     
                    if(i == 1)
                        idx = 0;
                }
            }
             
            System.out.println("#" + test_case + " " + sum);
        }
    }
}