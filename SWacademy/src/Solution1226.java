import java.util.Scanner;

public class Solution1226 {

	static int map[][]; //16 * 16 За·Д
	static int visit[][]; 
	static int starty, startx;
	static int Answer[] = new int[11];
	static int dy[]= {0,-1,0,1};
	static int dx[]= {-1,0,1,0};
	static int nexty;
	static int nextx;
	static int dfs(int y, int x, int result){
		visit[y][x] =1;
		if(map[y][x] == 3  || result ==1) return 1;
		for(int i=0 ; i< 4; i++){
			nexty = y+dy[i];
			nextx = x+dx[i];
			if(visit[nexty][nextx] != 1 &&nextx >= 0  && nexty >= 0 && nextx<16 && nexty< 16 && map[nexty][nextx]!=1 ){
			result = dfs(nexty, nextx, result);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		for(int tc = 1; tc<=10; tc++ ){
			visit = new int[16][16];
			map = new int[16][16];
			String str;
			int testCase = scan.nextInt();
			scan.nextLine();
			for(int i= 0; i < 16 ; i++){
				str = scan.nextLine();
				for(int j= 0 ; j< 16; j++){
					
					map[i][j] = str.charAt(j)-'0';
							
					if(map[i][j] == 2 ) {
						starty = i;
						startx = j;
					}
				}
			}
			
		/*	for(int i =0; i< 16 ; i++){
				System.out.println();
				for(int j=0; j<16; j++){
					System.out.print(map[i][j]);
				}
			}*/
			
			Answer[tc] = dfs(starty, startx, 0);
		}
		for(int i= 1 ; i<=10 ; i++){
			System.out.println("#"+i +" " + Answer[i]);
		}
	}

}
