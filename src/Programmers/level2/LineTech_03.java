package Programmers.level2;

import java.util.*;

public class LineTech_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int k = 12;
		solution(n,k);

	}
	
	public static int[] solution(int n, int k) {
		int answer[] = new int[2];
		
		// 초기화
		int seat[][] = new int[n][n];
		for(int i=0; i<seat.length; i++) {
			Arrays.fill(seat[i], Integer.MAX_VALUE);
		}
		Stack<Seat> st = new Stack<>();
		st.add(new Seat(1,1));
		calcuDistance(st, seat);
		
		for(int i=1; i<k; i++) {
			// 위치찾기
			st.add(findSeat(seat));
			calcuDistance(st, seat);
		}
		
		System.out.println(" 정답 " + st.peek().x + "   " + st.peek().y);
		answer[0] = st.peek().x;
		answer[1] = st.peek().y;
		return answer;
	}

	private static void calcuDistance(Stack<Seat> st, int[][] seat) {
		// TODO Auto-generated method stub
		Seat current_seat = st.peek();
		
		for(int i=0; i<seat.length; i++) {
			for(int j=0; j<seat.length; j++) {
				// 기존보다 거리가 더 작을 때 갱신
				// System.out.println(Math.abs(current_seat.x - (i+1)) + Math.abs(current_seat.y - (j+1)));
				int distance = Math.abs(current_seat.x - (i+1)) + Math.abs(current_seat.y - (j+1));
				
				if(distance < seat[i][j]) seat[i][j] = distance;
			}
		}
	}
	
	private static Seat findSeat(int[][] seat) {
		// TODO Auto-generated method stub
		int distance = Integer.MIN_VALUE;
		int resultX = 0;
		int resultY = 0;
		
		for(int i=seat.length-1; i>=0; i--) {
			for(int j=seat.length-1; j>=0; j--) {
				System.out.println("seat " + i + "  " + j + " = "  + seat[i][j] + " " +distance);
				// 가장 멀리있는 좌석 찾기
				if(distance <= seat[i][j]) {
					distance = seat[i][j];
					resultX = i+1;
					resultY = j+1;
				}
			}
		}
		
		System.out.println("findeSeat 좌표 " + resultX + "  " + resultY);
		return new Seat(resultX, resultY);
	}

}

class Seat{
	int x;
	int y;
	
	public Seat(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
