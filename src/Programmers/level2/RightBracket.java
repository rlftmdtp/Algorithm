package Programmers.level2;

import java.util.Stack;

public class RightBracket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean solution(String s) {
        boolean answer = true;

        char ch_array[] = s.toCharArray();
        Stack<Character> st = new Stack<Character>();
        
        for(int i=0; i<ch_array.length; i++){
            if(st.isEmpty()) st.add(ch_array[i]);
            else{
                char temp = st.peek();
                if(temp=='(' && ch_array[i] == ')') st.pop();
                else st.add(ch_array[i]);
            }
        }
        
        if(st.isEmpty()) return true;
        else return false;

    }
}
