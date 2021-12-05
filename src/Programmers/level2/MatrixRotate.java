package Programmers.level2;

public class MatrixRotate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rows = 6;
		int columns = 6;
		int queries[][] = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		solution(rows,columns, queries);
	}
	
	 public static int[] solution(int rows, int columns, int[][] queries) {
	        int[] answer = new int[queries.length];
	        
	        // 초기화
	        int MAP[][] = new int[rows][columns];
	        int count = 1;
	        for(int i=0; i<rows; i++){
	            for(int j=0; j<columns; j++){
	                // System.out.println(count);
	                MAP[i][j] = count++;
	            }
	        }
	        
	        for(int i=0; i<queries.length; i++){
	            int query[] = queries[i];
	            int x1 = query[0] - 1;
	            int y1 = query[1] - 1;
	            int x2 = query[2] - 1;
	            int y2 = query[3] - 1;
	            
	            int temp = MAP[x1][y1];
	            int MIN = temp;
	            // 시계방향 회전
	            for(int z1=x1; z1<x2; z1++) {
	                MAP[z1][y1] = MAP[z1+1][y1];
	                MIN = Math.min(MIN, MAP[z1][y1]);
	            }
	            
	            for(int z1=y1; z1<y2; z1++){
	                MAP[x2][z1] = MAP[x2][z1+1];
	                MIN = Math.min(MIN, MAP[x2][z1]);
	            }
	            
	            for(int z1=x2; z1>x1; z1--) {
	            	MAP[z1][y2] = MAP[z1-1][y2];
	            	MIN = Math.min(MIN, MAP[z1][y2]);
	            }
	            
	            for(int z1=y2; z1>y1+1; z1--) {
	            	MAP[x1][z1] = MAP[x1][z1-1];
	            	MIN = Math.min(MIN, MAP[x1][z1]);
	            }
	            
	            MAP[x1][y1+1] = temp;
	            System.out.println(MIN);
	            answer[i] = MIN;
	        }
	        
	        return answer;
	    }

}
