package leetcode.basic;

import java.util.HashSet;

public class ValidSudoku_36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isValidSudoku(char[][] board) {
    	
    	for(int i=0; i<board.length; i++) {
    		for(int j=0; j<board[0].length; j++) {
    			// System.out.println("x  =" + i + " y = " + j);
    			if(board[i][j] != '.')
    				if(!start(board, i,j)) return false;
    		}
    	}
    	
    	return true;
    }
    
    public boolean start(char[][] board, int x, int y) {
    	HashSet<Character> hs = new HashSet<>();
    	
    	// 가로 확인
    	for(int i=0; i<board[0].length; i++) {
    		if(hs.contains(board[x][i])) return false;
    		if(board[x][i] != '.') hs.add(board[x][i]);
    	}
    	
    	// 세로 확인
    	hs = new HashSet<>();
    	for(int i=0; i<board.length; i++) {
    		if(hs.contains(board[i][y])) return false;
    		if(board[i][y] != '.') hs.add(board[i][y]);
    	}
    	
    	// 3x3 확인
    	hs = new HashSet<>();
    	for(int i=x/3 * 3; i<x/3 *3 +3; i++) {
    		for(int j=y/3*3; j<y/3*3+3; j++) {
    			if(hs.contains(board[i][j])) return false;
    			if(board[i][j] != '.') hs.add(board[i][j]);
    		}
    	}
    	return true;
    }
    
    public boolean backTrack(char[][] board, int x, int y) {
    	
    	if(x == board.length-1 && y == board[0].length) return true;
    	else {
    		
    		// 행 전환
    		if(y == board[0].length) {
    			x += 1;
    			y = 0;
    		}
    		
    		if(board[x][y] == '.') {
    			// 숫자 탐색
    			for(int i=1; i<=9; i++) {
    				board[x][y] = (char)(i + (int)'0');
    				if(valid(board, x, y)) {
    					boolean tmp = backTrack(board, x, y+1);
    					if(tmp) return tmp;
    				}
    			}
    			board[x][y] = '.';
    		}else {
    			return backTrack(board, x, y+1);
    		}
    		
    		return false;
    	}
    }
    
    public boolean valid(char board[][], int x, int y) {
    	// 중복 숫자 체크 1~9
    	boolean check[] = new boolean[10];
    	
    	// 가로 체크
    	for(int i=0; i<board[0].length; i++) {
    		if(board[x][i] == '.') continue;
    		if(check[board[x][i] - '0']) return false;
    		check[board[x][i] - '0'] = true;
    	}
    	
    	// 세로 체크
    	check = new boolean[10];
    	for(int i=0; i<board.length; i++) {
    		if(board[i][y] == '.') continue;
    		if(check[board[i][y] - '0']) return false;
    		check[board[i][y] - '0'] = true;
    	}
    	
    	// 3 x 3 체크
    	check = new boolean[10];
    	for(int i=x/3 * 3; i<x/3 * 3 + 3; i++) {
    		for(int j=y/3 * 3; j<y/3 *3 + 3; j++) {
    			if(board[i][j] == '.') continue;
    			if(check[board[i][j] - '0']) return false;
    			check[board[i][j] - '0'] = true;
    		}
    	}
    	
    	return true;
    }
    

}
