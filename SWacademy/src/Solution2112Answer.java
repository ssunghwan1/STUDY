import java.util.Scanner;

public class Solution2112Answer {
	
	static Scanner sc = new Scanner(System.in);
	
	//W �ʺ� , D �� ��ȣ �ʸ�
	//D : ��ȣ�ʸ��� �β�
	//W : ��ȣ�ʸ��� �ʺ�
	//K : ��ȣ�ʸ� �հݱ���
	static final int DSIZE = 13;
	static final int WSIZE = 20;
	static int D, W, K;
	
	//film : �ʸ��� 2�������� ����
	//minChemicalCnt : ��ȣ�ʸ� ���ǿ� �����ϴ� ȭ��ó�� Ƚ���� �ּҰ��� ���
	//chemical : �� ��ȣ�� ���� ���� � ȭ��ó���� �ߴ��� ���
	// 0 -> ��ǰ A ����, 1 - > ��ǰ B ����, 2 - > ��ǰ ó�� ����
	static int film[][] = new int[DSIZE][WSIZE];
	static int minChemicalCnt;
	static int chemical[] = new int[DSIZE];
	
	//solve : ������ ��������� Ǯ�� ���� �Լ���.
	//curD : d ��° �ʸ��� �������� ���캼 ����
	//chemicalcnt : ��ǰ ó�� Ƚ��
	//prevContinuum : �������� ���ι������� ���� Ư���� ���ӵǴ� ���� ���� ����
	//prevMaxContinuum : �������� ���ι������� ���� Ư���� ���� ���� ���ӵǴ� ���� ������ ����
	static void solve(int curD, int chemicalCnt, int[] prevContinuum, int[] prevMaxContinue)
	{
		//�������� 1.
		//���� ó���� ��ǰ Ƚ���� ���ݱ��� ã�� ȭ��ó�� Ƚ���� �ּҰ����� ũ�� �� �̻� �� �ʿ䰡 ����.
		if(chemicalCnt >= minChemicalCnt) return;
		
		//�������� 2.
		//�ʸ��� ��� �� ����� ��
		if(curD == D)
		{
			//�ϳ��� �հݱ��ؿ� �������� ���ϸ� �������� �ʴ´ٰ� ó��
			boolean isSatisfied = true;
			for(int i=0; i< W ; i++)
			{
				if(prevMaxContinue[i] < K)
				{
					isSatisfied =  false;
					break;
				}
			}
			//�հݱ��ؿ� �����ϸ鼭, ���ݱ��� ã�� ȭ��ó�� Ƚ���� �ּҰ� ���� ������ �ּҰ��� ����
			if(isSatisfied && chemicalCnt < minChemicalCnt)
				minChemicalCnt = chemicalCnt;
			return;
		}
		
		int continuum[] = new int[WSIZE];
		int maxContinuum[] = new int[WSIZE];
		int prev, cur;
		
		//��ǰó���� ���� �ʰų�, B ��ǰ�� ó���ϰų�, A��ǰ�� ó���ϴ� ���� ���ʴ�� �����غ���.
		for(int i=2; i>= 0; i--){
			//i��° ��ǰ�� ó���� ��(0 : A��ǰ, 1: B��ǰ , 2: ��ǰó�� ����)
			chemical[curD] = i;
			
			//��� ���ι����� Ž���غ���.
			for(int j = 0 ; j < W ; j++)
			{
				//cur : ���� ���� ����
				//prev : �ٷ� ���� ���� ����
				cur = chemical[curD] == 2 ? film[curD][j] : chemical[curD];
				prev = chemical[curD - 1 ] ==2 ? film[curD-1][j] : chemical[curD -1];
				//cur�� prev�� ������ ���� ���� �� ������ +1�� �ϰ�, �ƴϸ� 1�� ����
				continuum[j] = cur == prev ? prevContinuum[j]+1 : 1;
				//���� ������ ���ӵǴ� ���� ������ ����
				maxContinuum[j] = continuum[j] > prevMaxContinue[j] ? continuum[j] : prevMaxContinue[j];
			}
			//���� ��°�� ��ȣ�ʸ��� ��� ���� Ȯ��
			solve(curD+1 , chemicalCnt + (i==2 ? 0 : 1), continuum, maxContinuum);
		}
	}
	public static void main(String[] args) {
		
		int test_case =sc.nextInt();
		for(int tc = 1; tc <= test_case ; tc++)
		{
			D = sc.nextInt(); W = sc.nextInt(); K = sc.nextInt();
			
			for(int i=0; i< D ; i++)
				for(int j=0; j<W ; j++)
					film[i][j] = sc.nextInt();
			
			minChemicalCnt = K;
			//continuum : ���� ���� �ʸ����� ���ι������� ���� Ư���� �����ϴ� ���� ���� ����
			//maxContinuum : ���� ���� �ʸ����� ���ι������� ���� Ư���� ���� ���� ���ӵǴ� ���� ������ ����
			
			int continuum[] = new int[WSIZE];
			int maxContinuum[] =new int[WSIZE];
			for(int i = 0 ; i< W ; i++)
				continuum[i] = maxContinuum[i] = 1;
			
			//0��° ���� �ʸ� ���� ��ǰó�� X
			chemical[0] = 2;
			solve(1,0, continuum, maxContinuum);
			
			//0���� ���� �ʸ� ���� ��ǰ A�� �ø��� �Ѵ�.
			chemical[0] = 0;
			solve(1, 1, continuum, maxContinuum);
			
			//0��° ���� �ʸ� ���� ��ǰ B ó���� �Ѵ�.
			chemical[0] = 1;
			solve(1, 1, continuum, maxContinuum);
		
			System.out.println("#" +tc + " " +minChemicalCnt);
		}
		

	}

}
