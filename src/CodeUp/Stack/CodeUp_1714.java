package CodeUp.Stack;

import java.io.*;
import java.util.Stack;


public class CodeUp_1714 { // 숫자 거꾸로 출력하기

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		char list[] = str.toCharArray();
		
		Stack<Character> st = new Stack<Character>();
		for(int i=0; i<list.length; i++) {
			st.push(list[i]);
		}
		
		while(!st.isEmpty()) {
			System.out.print(st.pop());
		}
	}

}
