package Programmers.level2;

public class QuardCompress {
	public static int zeroCount = 0;
	public static int oneCount = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
		solution(arr);
	
	}
	
    public static int[] solution(int[][] arr) {
        int[] answer = {};
        
        Position start = new Position(0, 0);
        Position end = new Position(arr.length, arr.length);
        compress(arr, start, end);
        
        int zeroCount = 0;
        int oneCount = 0;
        for(int i=0; i<arr.length; i++) {
        	for(int j=0; j<arr.length; j++) {
        		if(arr)
        	}
        }
        
        return answer;
    }

	private static void compress(int[][] arr, Position start , Position end) {
		// TODO Auto-generated method stub
		
		if(!search(arr, start, end)) {
			int newPos = (end.x - start.x) / 2;
			System.out.println("newPOst " + newPos);
			if(newPos > 1) {
				// 4개의 영역으로 재귀 실행
				compress(arr,start, new Position(newPos, newPos));  // 하단 왼쪽
				compress(arr,new Position(start.x, newPos), new Position(newPos, end.y)); // 하단 우측
				compress(arr,new Position(newPos, start.y), new Position(end.x, newPos)); // 상단 왼쪽
				compress(arr,new Position(newPos, newPos), end); // 상단 우측
			}
		}
	}

	private static boolean search(int[][] arr, Position start, Position end) {
		// TODO Auto-generated method stub
		System.out.println("search");
		int beginNumber = arr[start.x][start.y];
		for(int i=start.x; i<end.x; i++) {
			for(int j=start.y; j<end.y; j++) {
				if(arr[i][j] != beginNumber) return false;
			}
		}
		
		// 끝까지 통과하였으면 해당 맵을 동일한 숫자로 메꾸고 
		for(int i=start.x; i<end.x; i++) {
			for(int j=start.y; j<end.y; j++) {
				System.out.println("arr[" + i + "][" + j + "]" + beginNumber);
				arr[i][j] = beginNumber;
			}
		}
		
		return true;
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

