import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public int solution(int[] A) {
		int result;
		LinkedList<Integer> tmp = new LinkedList<>();		
		tmp.add(-1);
		for(int i=0; i<A.length; i++) {
			int tmpSize = tmp.size();
			for(int j=0; j< tmpSize; j++) {
				if(tmp.get(j) == A[i]) {
					tmp.remove(j);
					break;
				}
				if(j==(tmpSize-1)) {
					tmp.add(A[i]);
				}
				
			}
		
		}
		
		result = tmp.get(1);
		return result;
	}
	

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] a= {9,3,9,3,9,7,9};
		//int[] a= {1,2,3,4};
		System.out.println(sol.solution(a));
	}
}