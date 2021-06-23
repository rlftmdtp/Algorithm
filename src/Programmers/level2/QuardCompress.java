package Programmers.level2;

import sun.net.PortConfig;

public class QuardCompress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {};
		solution(arr);
	
	}
	
    public static int[] solution(int[][] arr) {
        int[] answer = {};
        
        Position start = new Position(0, 0);
        Position end = new Position(arr.length, arr.length);
        compress(arr, start, end);
        
        return answer;
    }

	private static void compress(int[][] arr, Position start , Position end) {
		// TODO Auto-generated method stub
		if(!search(arr, start, end)) {
			
		}
	}

	private static boolean search(int[][] arr, Position start, Position end) {
		// TODO Auto-generated method stub
		
		int beginNumber = arr[start.x][start.y];
		for(int i=start.x; i<end.y; i++) {
			
		}
		return false;
	}

}

class Position{
	int x;
	int y;
	
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

