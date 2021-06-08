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
        	
        	if(countEqual()) { // u�� �������� ���ڿ��� ���
        		if(u.peek() == '(') { // u�� �ùٸ� ��ȣ�� ���
        			while(!u.isEmpty()) {
        				answer += u.poll();
        			}
        			System.out.println("u�� �ùٸ� ��ȣ�� ��� " + answer);
        		}else {	// u�� �ùٸ��� ���� ��ȣ�� ���
        			answer += '(';
        			int limit = u.size();
        			int n = 0;
        			while(!u.isEmpty()) {
        				if(n == 0) u.poll(); // ù���� ����
        				else if(n == limit-1) u.poll(); // ���������� ����
        				else { // �ݴ�� �Է�
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
