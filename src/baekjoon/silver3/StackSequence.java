package baekjoon.silver3;

import java.io.*;
import java.util.*;


public class StackSequence {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int array[] = new int[n];
		for(int i=0; i<n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		Stack<Integer> st = new Stack<>();
		List<String> result = new ArrayList<>();
		int top = 0;
		for(int i=0; i<array.length; i++) {
			int N = array[i];
			
			// 자기 자신보다 같거나 작으면 빠지고
			// 자기 자신보다 크면 넣는다
			if(st.isEmpty()) {
				for(int j=top+1; j<=N; j++){
					st.push(j);
					result.add("+");
				}
				top = st.pop(); // 맨위 자기자신은 빠진다
				result.add("-");
			}else if(N < top){
				
				if(st.peek() != N) // NO인경우
				{
					System.out.println("NO");
					return;
				}
				else {
					st.pop();
					result.add("-");
				}
				
			}else { // N>TOP
				for(int j=top+1; j<=N; j++){
					st.push(j);
					result.add("+");
				}
				top = st.pop(); // 맨위 자기자신은 빠진다
				result.add("-");
			}
		}

		// 정답출력
		for(int i=0; i<result.size(); i++) {
			if(i == result.size()-1) System.out.print(result.get(i));
			else System.out.println(result.get(i));
		}
	}

}
