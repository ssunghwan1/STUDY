import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
 
public class Solution1240Answer {
    public static void printIntArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
 
    public static int word2int(String str) {
        String[] code_arr = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
                "0110111", "0001011" };
        for (int i = 0; i < code_arr.length; i++) {
            if (str.equals(code_arr[i])) {
                return i;
            }
        }
        return -1;
    }
 
    public static int[] str2intarr(String str) {
        String[] st = str.split("");
        int[] arr = new int[st.length];
        for (int i = 0; i < st.length; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }
        return arr;
    }
 
    public static boolean isStrZero(String str) {
        int[] arr = str2intarr(str);
        for (int i = 0; i < str.length(); i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
     
    public static boolean isNonNegativeCode(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return false;
            }
        }
        return true;
    }
    public static int[] str2code(String str) {
        int[] arr = new int[8];
        int[] full_arr = str2intarr(str);
        int start_idx = 0;
        for (int i = 0; i < full_arr.length; i++) {
            String word = str.substring(i, i + 7);
            if (word2int(word) >= 0) {
                start_idx = i;
                break;
            }
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[j] = word2int(str.substring(start_idx + j * 7, start_idx  + (j + 1) * 7));
            }
            if(isNonNegativeCode(arr)){
//              printIntArr(arr);
                break;
            }
            start_idx += 1;
        }
        return arr;
    }
     
    public static boolean isValidCode(int[] arr) {
        int val_code = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 1) {
                val_code += arr[i];
            } else{
                val_code += arr[i] * 3;
            }
        }
        if (val_code % 10 == 0) {
            return true;
        } else {
            return false;
        }
    }
     
    public static int sumIntArr(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
 
    public static void main(String[] args) throws IOException {
//      BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int Cases = Integer.parseInt(br.readLine());
        for (int case_id = 1; case_id < Cases + 1; case_id++) {
            int N, M;
            String[] str = br.readLine().split(" ");
            N = Integer.parseInt(str[0]);
            M = Integer.parseInt(str[1]);
            String code_str = null;
            for (int i = 0; i < N; i++) {
                String rl = br.readLine();
                if (isStrZero(rl)) {
                    continue;
                }
                code_str = rl;
            }
//          System.out.println(code_str);
            int[] code = str2code(code_str);
//          printIntArr(code);
            int ans = 0;
            if (isValidCode(code)) {
                ans = sumIntArr(code);
            }
            System.out.println("#" + case_id + " " + ans);
        }
        br.close();
    }
}