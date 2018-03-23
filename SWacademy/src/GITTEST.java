import java.util.LinkedList;
import java.util.Stack;

public class GITTEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> a =new Stack<>();
		a.push(1);
		a.push(3);
		a.push(7);
		a.push(2);
		a.push(11);
		a.sort(null);
		
		while(!a.isEmpty()){
			System.out.println(a.pop());
		}
 	}

}
