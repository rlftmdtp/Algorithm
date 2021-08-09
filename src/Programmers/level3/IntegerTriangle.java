package Programmers.level3;

public class IntegerTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int result[][] = new int[triangle.length][triangle.length];
        result[0][0] = triangle[0][0];
        for(int i=1; i<triangle.length; i++) {
        	
        	for(int j=0; j<i+1; j++) {
        		if(j==0) result[i][j] = result[i-1][j] + triangle[i][j];
        		else if(j==i) result[i][j] = result[i-1][j-1] + triangle[i][j];
        		else {
        			result[i][j] = Math.max(result[i-1][j-1], result[i-1][j]) + triangle[i][j];
        		}
        	}
        }
        
        for(int i=0; i<triangle.length; i++) {
        	if(answer < result[triangle.length-1][i]) answer = result[triangle.length-1][i];
        }
        
        return answer;
    }

}
