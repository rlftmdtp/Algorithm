package CodeUp.Stack;

import java.io.*;
import java.util.Stack;

public class CodeUp_2016 { // 천단위 구분기호

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		char ch[] = br.readLine().toCharArray();
		Stack<Character> st = new Stack<Character>();
		
		int count = 0;
		for(int i=n-1; i>=0; i--) {
			count++;
			st.push(ch[i]);
			if(count % 3 == 0 && i != 0) st.push(',');
		}
	
		while(!st.isEmpty()) {
			System.out.print(st.pop());
		}
	}

}
