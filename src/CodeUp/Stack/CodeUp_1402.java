package CodeUp.Stack;

import java.io.*;
import java.util.Stack;

public class CodeUp_1402 { // 거꾸로 출력하기 3

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Stack<String> st = new Stack<String>(); 
		
		int list[] = new int[n];
		
		String strSplit[] = br.readLine().split("\\s");
		for(int i=0; i<n; i++) {
			st.push(strSplit[i]);
		}
		
		while(!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
	}

}
