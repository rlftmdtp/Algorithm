package Programmers.level1;

import java.io.*;
import java.util.*;

public class ClawMachineGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	}

    public int solution(int[][] board, int[] moves) {
        int result = 0; // 정답
        Stack<Integer> basket = new Stack<Integer>();
        		
        for(int i=0; i<moves.length; i++) {
        	int current = moves[i]-1;
        	
        	// 크레인이 위에서부터 아래로 내려온다
        	int doll = 0; // 인형
        	for(int j=board.length-1; j>=0; j--) {
        		if(board[current][j] != 0) { // 인형을 뽑으면
        			doll = board[current][j];
        			board[current][j] = 0;
        			break;
        		}
        	}
        	
        	if(!basket.isEmpty()) {
        		if(basket.peek() == doll) { // 바구니에 같은 인형이 존재 할 경우
            		result = result+2;
            		basket.pop();
        		} else basket.push(doll);
        	} else basket.push(doll);
        }
        
        return result;
    }
}
