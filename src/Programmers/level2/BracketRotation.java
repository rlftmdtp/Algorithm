package Programmers.level2;

import java.util.*;

public class BracketRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "}}}";
		System.out.println(solution(s));
	}
	
    public static int solution(String s) {
		int answer = 0;

		for (int i = 0; i < s.length(); i++) {
			Stack<Integer> st = new Stack<>();
			for (int j = 0; j < s.length(); j++) {
				char bracket = s.charAt(j);
				if (checkBracket(bracket) % 2 == 0) { // ������ȣ
					st.push(checkBracket(bracket));

				} else { // ���ȣ �� ¦�� �´��� �˻�
					if (!st.isEmpty() && st.peek() == checkBracket(bracket) - 1) { // ¦�� �������
						st.pop();
					}else if(st.isEmpty()){ // ���ȣ�ε� ¦�� �������� Ʋ�� ���ڿ��̹Ƿ� �ٷ� ���
						st.push(-1);
						break;
					}
				}
			}
			if(st.isEmpty()) answer ++;
			s = s.substring(1, s.length()) + s.substring(0,1);
		}
        return answer;
    }
    
    public static int checkBracket(char ch) {
    	char chArray[] = {'[', ']', '{', '}', '(', ')' };
    	for(int i=0; i<chArray.length; i++) {
    		if(chArray[i] == ch) return i;
    	}
    	return -1;
    }

}
