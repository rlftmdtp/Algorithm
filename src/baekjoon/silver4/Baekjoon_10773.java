package baekjoon.silver4;

import java.util.*;
import java.io.*;

public class Baekjoon_10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) st.pop();
			else st.add(n);
		}
		
		int result = 0;
		while(!st.isEmpty()) {
			result += st.pop();
		}
		
		System.out.println(result);
	}

}
