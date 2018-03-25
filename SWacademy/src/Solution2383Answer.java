import java.util.Scanner;

public class Solution2383Answer {
	
	//�濡���� ��ġ�� ��Ÿ���� Ŭ����
	static class PT {
		int r, c;
		//(r, c) : r ���� ���� ����° ��
		public PT(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static int MAXN = 11;
	static int MAXT = 11 * 2 + 11*11; //?
	//N : ���� �� ���� ����, M : ����� ��, S( = 2) : ����� ��
	//map : �Է����� �־����� ���� ����
	//match[x] = y: x ��° ������ y��° ����� Ÿ���� ������ ����
	static int N;
	static int map[][], match[];
	static int M, S;
	
	static int answer;
	static PT man[], stair[];
	
	static int abs(int x){
		if (x >= 0) return x;
		return -x;
	}
	
	static int max(int x, int y){
		if(x>=y ) return x;
		return y;
	}
	
	static int min(int x, int y){
		if(x>=y) return y;
		return x;
	}
	static int dist(int man_index, int stair_index){
		int dx =abs(man[man_index].r - stair[stair_index].r);
		int dy = abs(man[man_index].c - stair[stair_index].c);
		return dx + dy;
	}
	
	//�� ����� ��� ����� �̿��� �� ��� �������� ���� �ʿ��� �ð��� ����ϴ� �Լ�
	static void update(){
		//��� ������� ����� �������µ� �ʿ��� �ּ� �ð�
		int total_min_time  = 0;
		
		//�� ����� ���� �������̹Ƿ� ������ ���ؼ� ����Ѵ�.
		for(int stair_index =0 ; stair_index < 2; stair_index++){
			PT now_stair =  stair[stair_index];

			//arriaval_time[t] : �ð� t�� �� ��ܿ� �����ϴ� ����� ��
			int arrival_time[] = new int[MAXN *2];
			//current_stair[t] : �ð� t�� �� ����� �������� �ִ� ����� ��
			int current_stair[] = new int[MAXT];
			
			//�ʱ�ȭ
			for(int i=0; i<MAXT ; i++) current_stair[i] = 0;
			for(int i=0; i<2 * MAXN; i++ ) arrival_time[i] = 0;
			
			
			for(int man_index = 0; man_index < M ; man_index++){
				if(match[man_index] == stair_index){
					arrival_time[dist(man_index, stair_index)+1]++;
				}
			}
			
			//stair_index ���� ����� �������� ����� ��� �۾��� ��ġ�� ���� �ʿ��� �ּ� �ð�
			int now_min_time= 0;
			//��ܿ� �����ϴ� �ð� ������������ �� ����� ����� ���������� �ùķ��̼�
			for(int time = 1; time <=20 ; time++){
				
				//time�� ������ ����� �ִٸ�
				while(arrival_time[time] > 0 ){
					arrival_time[time] --;
					//�ش� ����� �������µ� �ʿ��� �ð�
					int remain_time = map[now_stair.r][now_stair.c];
					
					//������ �������� ��� 3���� ���ÿ� �������� ���� ���� ���� 1ĭ�� ������ ���� ������
					for(int walk_time = time; walk_time < MAXT ; walk_time++){
						if(current_stair[walk_time]<3){
							
							current_stair[walk_time]++;
							remain_time--;
							
							//����� �� ���������� now_min_time ����
							if(remain_time == 0){
								now_min_time = max(now_min_time, walk_time+1);
								break;
							}
						}
					}
					
					
					
				}
			}
			
			
			//��ü ����� �������µ� �ʿ��� �ּ� �ð��� (�� ����� �������µ� �ʿ��� �ּ� �ð�) �� �ִ�
			total_min_time = max(total_min_time, now_min_time);
			
			
		}
		//���� match ������ ���� total_min_time�� �������� ����
		answer = min(answer, total_min_time);
			
	}
	static void dfs(int man_index){
		//��� ����� ���� �� ����� ����� ����� �� ���ߴٸ�
		if(man_index == M ){
			//�شܻ��¿��� �ʿ��� �ð��� ����ϰ� ���� ����
			update();
			return;
		}
		//man_index ��° ����� stair_index ��° ����� �����ϰ�, ��� ȣ��
		for(int stair_index = 0; stair_index<2 ; stair_index++){
			match[man_index] = stair_index;
			dfs(man_index+1);
		}
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int tc = 1; tc<=T ; tc++){
			N = scan.nextInt();
			M = S = 0;
			map = new int[N+2][N+2];
			man = new PT[N*N];
			stair = new PT[2];
			
			for(int i=1;i<=N; i++){
				for(int j=1; j<=N; j++){
					map[i][j] = scan.nextInt();
					//���� (i,j)�� ����̸�, �ش� ��ġ��  man�� ����
					if(map[i][j] == 1) man[M++] = new PT(i, j);
					//���� (i,j)�� ����̸�, �ش� ��ġ�� stair�� ����
					if(map[i][j] >=2 ) stair[S++] = new PT(i,j);
				}
			}
			//���� ���Ѵ�� �ʱ�ȭ
			answer = 987654321;
			match = new int[M];
			//���� �켱 Ž�� ����
			dfs(0);
			System.out.println("#" + tc + " " + answer);
		}

	}

}
