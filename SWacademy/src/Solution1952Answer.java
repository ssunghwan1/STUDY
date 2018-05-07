import java.util.Scanner;

public class Solution1952Answer {

	//최속값 초기화 2*30 값 입력함
	static int max = 1 <<30;
	
	static int[] costtable = new int[4];
	//이용 횟수
	static int[] Plan = new int[13];
	//백트래킹 방식으로 찾을 함수
	static void Search(int month, int cost)
	{
		//계산 중 12월이 지나갈 경우 재귀를 멈추기 위하여 검사를 함
		if(month >= 12)
		{
			//현재 전달된 cost 의 입력을 확인하여 min 값보다 작은 경우 min에 값을 넣어준다.
			//결과적으로 가장 작은 비용을 가지고 123월을 도착하는 숫자가 min 에 남게 됩니다.
			if(cost < max)
				max = cost;
			//12월까지 계산을 모두 했으니 더 이상 Search를 찾지 않고 한 단계 전으로 돌아갑니다.
			return;
		}
		//month 달에 1일 이용권을 이용하도록 비용을 계산하고 다음 달로 넘어갑니다
		Search(month + 1, cost+ costtable[0] * Plan[month]);
		//month 달을 한달 이용권으로 계산해서 ...
		Search(month + 1, cost + costtable[1]);
		//month 달을 3달 이용권으로 계산해서...
		Search(month+3 , cost + costtable[2]);
		//month달을 1년 이용권으로 계산해서 ...
		Search(month + 12 , cost + costtable[3]);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		for(int test_case = 1 ; test_case <=t ; test_case++)
		{
			//최속값 초기화 2^30 값 입력함
			max = 1<<30;
			for(int i=0; i<4; i++)
				costtable[i] =scan.nextInt();
			for(int i=0; i< 12; i++)
				Plan[i] = scan.nextInt();
			Search(0,0);
			System.out.println("#" + test_case+" " + max);
		}
	

	}

}
