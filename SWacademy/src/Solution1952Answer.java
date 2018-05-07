import java.util.Scanner;

public class Solution1952Answer {

	//�ּӰ� �ʱ�ȭ 2*30 �� �Է���
	static int max = 1 <<30;
	
	static int[] costtable = new int[4];
	//�̿� Ƚ��
	static int[] Plan = new int[13];
	//��Ʈ��ŷ ������� ã�� �Լ�
	static void Search(int month, int cost)
	{
		//��� �� 12���� ������ ��� ��͸� ���߱� ���Ͽ� �˻縦 ��
		if(month >= 12)
		{
			//���� ���޵� cost �� �Է��� Ȯ���Ͽ� min ������ ���� ��� min�� ���� �־��ش�.
			//��������� ���� ���� ����� ������ 123���� �����ϴ� ���ڰ� min �� ���� �˴ϴ�.
			if(cost < max)
				max = cost;
			//12������ ����� ��� ������ �� �̻� Search�� ã�� �ʰ� �� �ܰ� ������ ���ư��ϴ�.
			return;
		}
		//month �޿� 1�� �̿���� �̿��ϵ��� ����� ����ϰ� ���� �޷� �Ѿ�ϴ�
		Search(month + 1, cost+ costtable[0] * Plan[month]);
		//month ���� �Ѵ� �̿������ ����ؼ� ...
		Search(month + 1, cost + costtable[1]);
		//month ���� 3�� �̿������ ����ؼ�...
		Search(month+3 , cost + costtable[2]);
		//month���� 1�� �̿������ ����ؼ� ...
		Search(month + 12 , cost + costtable[3]);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		for(int test_case = 1 ; test_case <=t ; test_case++)
		{
			//�ּӰ� �ʱ�ȭ 2^30 �� �Է���
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
