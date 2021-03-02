package Programmers.level1;

import java.io.*;
import java.util.*;

public class IntToIntArray { // 자연수 뒤집어 배열로 만들기

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		
		solution(n);
	}

	private static int[] solution(long n) {
		// TODO Auto-generated method stub
		// 뒤집어진 배열로 변환
		char chArray[] = Long.toString(n).toCharArray();
		Stack<Character> st = new Stack<Character>();
		
		for(int i=0; i<chArray.length; i++) {
			st.add(chArray[i]);
		}
		
		int answer[] = new int[chArray.length];
		int i=0;
		while(!st.isEmpty()) {
			answer[i++] = st.pop() - '0';
		}
		return answer;
	}

}
