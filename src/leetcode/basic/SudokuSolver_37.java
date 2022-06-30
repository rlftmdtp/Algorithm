package leetcode.basic;

public class SudokuSolver_37 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
		// Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
		solveSudoku(board);
	}
	
    public static void solveSudoku(char[][] board) {
       
    	// BackTracking..
    	backTrack(board, 0, 0);
    }
    
    public static boolean backTrack(char[][] board, int x, int y) {
    	
    	if(x == board.length && y == board[0].length) return true;
    	else {
			// 다음 행 
			if(y == board[0].length) {
				x += 1;
				y = 0;
			}
			
			if(board[x][y] == '.') {
				// 숫자
				for(int j=1; j<=9; j++) {
					board[x][y] = (char)((int)'0' + j);
					     
					if(valid(board, x, y)) {
						boolean tmp =  backTrack(board, x, y+1);
						if(tmp == true) return true;
					}
				} d
				
			}else {
				return backTrack(board, x, y+1);
			}

			return false;	
    	}
    }
    
    public static boolean valid(char[][] board, int x, int y) {
    	System.out.println("y = " + y );
    	// 가로 확인 
    	boolean check[] = new boolean[9];
    	for(int i=0; i<9; i++) {
    		if(board[x][i] == '.') continue;
    		if(check[board[x][i] - '0' -1] == true) return false;
    		check[board[x][i] - '0' -1] = true;
    	}
    	
    	// 세로 확인
    	check = new boolean[9];
    	for(int i=0; i<9; i++) {
    		if(board[i][y] == '.') continue;
    		if(check[board[i][y] - '0' -1] == true) return false;
    		check[board[i][y] - '0' -1] = true;
    	}
    	
    	// 3 x 3 확인
    	check = new boolean[9];
    	for(int i=x/3 * 3 ; i<x/3 * 3 + 3; i++) {
    		for(int j=y/3 * 3; j<y/3 *3 + 3; j++) {
    			System.out.println("i = " + i + "  j = " + j);
        		if(board[i][j] == '.') continue;
        		if(check[board[i][j] - '0' -1] == true) return false;
        		check[board[i][j] - '0' -1] = true;
    		}
    	}
    	
    	return true;
    }

}
