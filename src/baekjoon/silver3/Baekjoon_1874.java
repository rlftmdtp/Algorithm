package baekjoon.silver3;

import java.util.*;
import java.io.*;

public class Baekjoon_1874 {
	public static List<String> result = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> st = new Stack<>();
		int top = 0;
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());

			if(st.isEmpty()) top = addSt(st, top, n);
			else {
				if(st.peek() == n) {
					st.pop();
					result.add("-");
				}else if(st.peek() > n) {
					result = new ArrayList<>();
					System.out.println();
					result.add("No");
					break;
				}else {
					top = addSt(st, top, n);
				}
			}
			
		}
		
		for(String str : result) {
			System.out.println(str);
		}
	}

	private static int addSt(Stack<Integer> st, int top, int n) {
		// TODO Auto-generated method stub
		for(int i=top+1; i<=n; i++) {
			st.push(i);
			result.add("+");
			top = i;
		}
			st.pop();
			result.add("-");
			
		return top;
	}

}
