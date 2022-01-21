package Programmers.level3;

public class Kakao2022NotDestoryBuilding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
		int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
		solution(board, skill);
	}
	
    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        for(int i=0; i<skill.length; i++) {
        	int s[] = skill[i];
        	skillImpact(board, s);
        }
        for(int i=0; i<board.length; i++) {
        	for(int j=0; j<board[0].length; j++) {
        		if(board[i][j] >= 1) answer++;
        		// System.out.println("행 " + i + " 열 " + j + " " + board[i][j]);
        	}
        }
        // System.out.println("정답 " + answer);
        return answer;
    }
    
    public static void skillImpact(int[][] board, int[] s) {
    	if(s[0] == 1) {	// 공격
    		for(int i=s[1]; i<=s[3]; i++) {
    			for(int j=s[2]; j<=s[4]; j++) {
    				// System.out.println("행 " + i + " 열 " + j + " " + board[i][j]);
    				board[i][j] -= s[5];
    				// System.out.println("공격 다한 후의 값 " + board[i][j]);
    			}
    		}
    	}else { // 회복
    		for(int i=s[1]; i<=s[3]; i++) {
    			for(int j=s[2]; j<=s[4]; j++) {
    				board[i][j] += s[5];
    			}
    		}
    	}
    }

}
