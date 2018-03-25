import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution2383 {

	static class Stair{
		int y;
		int x;
		int length;
		public Stair(int y,  int x, int length){
			this.y = y;
			this.x = x;
			this.length = length;

		}
	}
	
	static class Person{ //y,x 빼보기
		
		int y;
		int x;
		int selectStair;
		int spendTime; //계단까지 도착할 것
		int leftTime; //사다리에서 남은 시간
		public Person(int y, int x){
			this.y = y;
			this.x = x;	
		}
		public Person(int selectStair) {
			this.selectStair = selectStair;
		}
	}
	
	static int T;
	static int N;
	static int map[][];
	static Queue<Person> stairA;
	static Queue<Person> stairB;
	static Queue<Person> inStairA;
	static Queue<Person> inStairB;
	static LinkedList<Person> arrPerson;
	static int Result;
	static ArrayList<Stair> arrStair;
	
	static void calSpendTime(){
		for(int i=0 ; i<arrPerson.size(); i++){
			
			if(arrPerson.get(i).selectStair ==1 ){
				arrPerson.get(i).spendTime
				= Math.abs(arrStair.get(0).y -arrPerson.get(i).y)
				+Math.abs(arrStair.get(0).x - arrPerson.get(i).x); 
			}else{
				arrPerson.get(i).spendTime 
				= Math.abs(arrStair.get(1).y -arrPerson.get(i).y)
						+Math.abs(arrStair.get(1).x - arrPerson.get(i).x);
			}
		}
	}

	
	static void calResult(){
		calSpendTime();
		int time =0;
		int finished=0;
		stairA = new LinkedList<>();
		stairB = new LinkedList<>();
		inStairA = new LinkedList<>();
		inStairB = new LinkedList<>();
		
		//큐에 저장(대기줄)
		/*for(int i=0 ; i< arrPerson.size(); i++){
			if( arrPerson.get(i).selectStair == 0){
				stairA.add(arrPerson.get(i));
			}else{
				stairB.add(arrPerson.get(i));
			}
		}
		*/
			
		while(true){
			time ++;			
			
			for(int i= 0 ; i < inStairA.size(); i++){
				inStairA.peek().leftTime --;
				if(inStairA.peek().leftTime ==0 ){
					inStairA.poll();
				}
			}
			
			//계단에 도착한 Person을 계단 대기 큐에 삽입
			for(int i=0; i< arrPerson.size() ; i++){
				if(arrPerson.get(i).spendTime == time){
					if(arrPerson.get(i).selectStair == 0){
						arrPerson.get(i).leftTime = arrStair.get(0).length;
						stairA.add(arrPerson.get(i));
					}else{
						arrPerson.get(i).leftTime = arrStair.get(1).length;
						stairB.add(arrPerson.get(i));						
					}
				}
			}		
			
			if(inStairA.size() < 3 && !stairA.isEmpty()){
				inStairA.add(stairA.poll()); //계단 내려가기 시작
			}
			if(inStairB.size() < 3 && !stairB.isEmpty()){
				inStairB.add(stairB.poll()); //계단 내려가기시작
			}
			
			
			
			
			
		}
		
	}
	
	static void dfsSolution(int start){
		
		if(start == arrPerson.size()){
			calResult();
			return;
		}
		
		for(int i=0; i<= 1; i++){
			arrPerson.get(start).selectStair =i;			
			dfsSolution(start+1);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T =  scan.nextInt();
		for(int test_case = 1; test_case<= T; test_case++ ){
			map= new int[10][10];
			arrPerson = new LinkedList<>();
			N = scan.nextInt();
			arrStair = new ArrayList<>();
			Result = 987654321;
			for(int i = 0; i< N ; i++){
				for(int j= 0 ; j< N ; j++){
					map[i][j] = scan.nextInt();
					if(map[i][j] == 1){ // 사람
						arrPerson.add(new Person(i, j));
					}
					if(map[i][j] >1){//계단
						arrStair.add(new Stair(i, j,map[i][j]));
					}
				}
			}
			
			dfsSolution(0);
			
			
			
			
		
			
			
			
			
			
		}
				
		
	}

}
