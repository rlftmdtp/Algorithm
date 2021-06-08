package Programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class KakaoBlindRecruitment2020 {

    public static int leftCount = 0;
    public static int rightCount = 0;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("()))(( ()"));

	}
	
    public static String solution(String p) {
        String answer = "";
        
        Queue<Character> u = new LinkedList<Character>();

        
        for(int i=0; i<p.length(); i++) {
        	count(p.charAt(i));
        	u.add(p.charAt(i));
        	
        	if(countEqual()) { // u과 균형잡힌 문자열일 경우
        		if(u.peek() == '(') { // u가 올바른 괄호일 경우
        			while(!u.isEmpty()) {
        				answer += u.poll();
        			}
        			System.out.println("u가 올바른 괄호일 경우 " + answer);
        		}else {	// u가 올바르지 않은 괄호일 경우
        			answer += '(';
        			int limit = u.size();
        			int n = 0;
        			while(!u.isEmpty()) {
        				if(n == 0) u.poll(); // 첫글자 제거
        				else if(n == limit-1) u.poll(); // 마지막글자 제거
        				else { // 반대로 입력
        					if(u.poll() == '(') answer += ')';
        					else answer += '(';
        				}
        			}	
        		}
        	}
        }
        
        return answer;
    }
   
	public static void count(char c) {
    	if(c == '(') leftCount++;
    	else rightCount++;
    }
	
    private static boolean countEqual() {
		// TODO Auto-generated method stub
    	if(leftCount == rightCount) return true;
    	else return false;
	}

}
