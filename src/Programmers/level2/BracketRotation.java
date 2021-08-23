package Programmers.level2;

import java.util.*;

public class BracketRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "}}}";
		System.out.println(solution(s));
	}
	
    public static int solution(String s) {
		int result = 0;
		
		Queue<Character> q = new LinkedList<Character>();
		for(int i=0; i<s.length(); i++) {
			q.add(s.charAt(i));
		}
		
		for(int i=0; i<s.length(); i++) {
			q.add(q.poll());
			
			Stack<Character> st = new Stack<Character>();
			for(char str : q) {
				// 왼쪽 괄호면 푸쉬
				if(str == '(' || str == '{' || str == '[') st.push(str);
				else{ // 오른쪽 괄호면 비교한다
					if(st.isEmpty()) {
						st.push('e');
						break;
					}
					else {
						// 맞는 괄호일 경우 제거
						if(str == ')' && st.peek() == '(') st.pop();
						else if(str == '}' && st.peek() == '{') st.pop();
						else if(str == ']' && st.peek() == '[') st.pop();
					}
				}
			}
			
			if(st.isEmpty()) result++;
		}
		System.out.println(result);
		return result;
    }

}
