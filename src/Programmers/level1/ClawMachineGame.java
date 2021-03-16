package Programmers.level1;

import java.io.*;
import java.util.*;

public class ClawMachineGame { // ũ���� �����̱�

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

    public int solution(int[][] board, int[] moves) {
        int result = 0; // ����
        Stack<Integer> basket = new Stack<Integer>();
        		
        for(int i=0; i<moves.length; i++) {
        	int current = moves[i]-1;
        	
        	// ũ������ ���������� �Ʒ��� �����´�
        	int doll = 0; // ����
        	for(int j=board.length-1; j>=0; j--) {
        		if(board[j][current] != 0) { // ������ ������
        			doll = board[j][current];
        			board[j][current] = 0;
        			break;
        		}
        	}
        	
        	if(doll != 0) {
            	if(!basket.isEmpty()) {
            		if(basket.peek() == doll) { // �ٱ��Ͽ� ���� ������ ���� �� ���
                		result = result+2;
                		basket.pop();
            		} else basket.push(doll);
            	} else basket.push(doll);
        	}
        }
        
        return result;
    }
}
