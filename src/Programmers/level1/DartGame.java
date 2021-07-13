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
        
        // 3번의 기회
        // S D T 점수에서 1제곱 2제곱 3제곱
        // * : 해당 점수와 바로 전에 얻은 점수를 각 2배로
        // # : 해당 점수는 마이너스
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
		
		// S D T 계산
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
	        // * : 해당 점수와 바로 전에 얻은 점수를 각 2배로
	        // # : 해당 점수는 마이너스
			// 스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. 
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
