package baekjoon.silver4;

import java.util.*;
import java.io.*;

public class Baekjoon_9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		List<String> result = new ArrayList<>();
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			char charArray[] = str.toCharArray();
			
			Stack<Character> st = new Stack<>();
			for(int j=0; j<charArray.length; j++) {
				if(st.isEmpty()) {
					if(charArray[j] == '(') st.push(charArray[j]);
					else {
						st.add('(');
						break;
					}
				}else {
					if(charArray[j] == '(') st.push(charArray[j]);
					else st.pop();
				}
			}
			
			if(st.isEmpty()) result.add("YES");
			else result.add("NO");
		}
		
		for(String str : result) {
			System.out.println(str);
		}
	}

}
