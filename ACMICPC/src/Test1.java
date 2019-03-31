import java.util.*;
public class Test1 {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(3);
		a.add(2);
		
		/*Collections.sort(a);
		for(int i : a) {
			System.out.println(i);
		}*/
		Collections.reverse(a);
		for(int i : a) {
			System.out.println(i);
		}
	}

}
