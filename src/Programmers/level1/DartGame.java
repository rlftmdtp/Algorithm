package Programmers.level1;

import java.util.*;

public class DartGame {
	public static Stack<Integer> st = new Stack<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dartResult = "1D#2S*3S";
		solution(dartResult);
	}
	
    public static int solution(String dartResult) {
        int answer = 0;
        
        // 3���� ��ȸ
        // S D T �������� 1���� 2���� 3����
        // * : �ش� ������ �ٷ� ���� ���� ������ �� 2���
        // # : �ش� ������ ���̳ʽ�
        String numberArray[] = dartResult.split("\\D+");
        String dartChArray[]= dartResult.split("[0-9]+");
        
        for(int i=0; i<numberArray.length; i++) {
        	st.add(dartCal(numberArray[i], dartChArray[i+1]));
        }
        
        while(!st.isEmpty()) {
        	answer += st.pop();
        }
        System.out.println(answer);
        return answer;
    }

	private static int dartCal(String string, String string2) {
		System.out.println("string " + string + " string2 " + string2);
		// TODO Auto-generated method stub
		int n = Integer.parseInt(string);
		
		// S D T ���
		char ch = string2.charAt(0);
		switch (ch) {
		case 'S': {
			break;
		}
		case 'D': {
			n = n * n;
			break;
		}
		case 'T': {
			n = n * n * n;
			break;
		}
		}
		
		if(string2.length()==2) {
	        // * : �ش� ������ �ٷ� ���� ���� ������ �� 2���
	        // # : �ش� ������ ���̳ʽ�
			// ��Ÿ��(*)�� ù ��° ��ȸ������ ���� �� �ִ�. �� ��� ù ��° ��Ÿ��(*)�� ������ 2�谡 �ȴ�. 
			if(string2.charAt(1) == '*') {
				n = n * 2;
				if(!st.isEmpty()) st.add(st.pop() * 2);
			}else {
				n = n * -1;
			}
		}
		System.out.println("n " + n);
		return n;
	}

}
