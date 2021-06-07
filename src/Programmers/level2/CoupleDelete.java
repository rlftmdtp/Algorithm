package Programmers.level2;

import java.util.*;

public class CoupleDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "baabaa";
		System.out.println(solution(s));
	}
	
    public static int solution(String s)
    {   
    	int answer = 0;
        Stack<Character> st = new Stack<Character>();
        
        for(int i=0; i<s.length(); i++) {
        	if(st.isEmpty()) st.push(s.charAt(i));
        	else {
        		if(st.peek() != s.charAt(i)) st.push(s.charAt(i));
        		else st.pop(); // 같은 경우 두개 제거
        	}
        }
        
        if(st.isEmpty()) answer = 1;
        return answer;
    }

}
