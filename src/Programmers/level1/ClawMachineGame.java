package Programmers.level1;

import java.io.*;
import java.util.*;

public class ClawMachineGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	}

    public int solution(int[][] board, int[] moves) {
        int result = 0; // ����
        Stack<Integer> basket = new Stack<Integer>();
        		
        for(int i=0; i<moves.length; i++) {
        	int current = moves[i]-1;
        	
        	// ũ������ ���������� �Ʒ��� �����´�
        	int doll = 0; // ����
        	for(int j=board.length-1; j>=0; j--) {
        		if(board[current][j] != 0) { // ������ ������
        			doll = board[current][j];
        			board[current][j] = 0;
        			break;
        		}
        	}
        	
        	if(!basket.isEmpty()) {
        		if(basket.peek() == doll) { // �ٱ��Ͽ� ���� ������ ���� �� ���
            		result = result+2;
            		basket.pop();
        		} else basket.push(doll);
        	} else basket.push(doll);
        }
        
        return result;
    }
}
