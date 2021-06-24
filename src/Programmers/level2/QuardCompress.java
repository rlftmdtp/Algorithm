package Programmers.level2;

public class QuardCompress {
	public static int zeroCount = 0;
	public static int oneCount = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
		solution(arr);
	
	}
	
    public static int[] solution(int[][] arr) {
        int[] answer = new int[2];
        System.out.println(arr[5][7] + "arr test");
        Position start = new Position(0, 0);
        Position end = new Position(arr.length, arr.length);
        compress(arr, start, end);
        
        answer[0] = zeroCount;
        answer[1] = oneCount;
        System.out.println(zeroCount + ", " + oneCount);
        return answer;
    }

	private static void compress(int[][] arr, Position start , Position end) {
		// TODO Auto-generated method stub
		
		if(!search(arr, start, end)) {
			int newPos = (end.x - start.x) / 2;
			System.out.println("newPOst " + newPos + " " + start.x + start.y + " " + end.x + end.y);
			if(newPos > 1) {
				// 4개의 영역으로 재귀 실행
				compress(arr,start, new Position(start.x + newPos, start.y + newPos));  // 하단 왼쪽
				compress(arr,new Position(start.x, start.y+newPos), new Position(start.x + newPos, end.y)); // 하단 우측
				compress(arr,new Position(start.x+newPos, start.y), new Position(end.x, end.y-newPos)); // 상단 왼쪽
				compress(arr,new Position(start.x + newPos, start.y + newPos), end); // 상단 우측
			}else if(newPos == 1) { // 끝까지 재귀 수행 후 숫자 카운트
				for(int i=start.x; i<end.x; i++) {
					for(int j=start.y; j<end.y; j++) {
						System.out.println("arr[" +   i + "][" + j + "] = "  + arr[i][j]);
						if(arr[i][j] == 1) oneCount++;
						else zeroCount++;
					}
				}
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
		
		// 끝까지 통과하였으면 해당 맵을 동일한 숫자로 매꾼다(숫자 카운트)
		if(beginNumber == 1) oneCount++;
		else zeroCount++;
		
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

