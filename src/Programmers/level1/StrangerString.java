package Programmers.level1;

import java.io.*;

public class StrangerString { // 이상한 문자 만들기

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s= br.readLine();
		System.out.println(solution(s));
	}

	private static String solution(String s) {
		// TODO Auto-generated method stub
		String asnwer = "";
		
		int count = 0;
		char ch = ' ';
		for(int i=0; i<s.length(); i++) {
			ch = s.charAt(i);
			
			// 공백이면 리셋
			if(ch == ' ') count = 0;
			else {
				if(count%2 == 1) ch = Character.toLowerCase(ch);
				else ch = Character.toUpperCase(ch);
				count++;
			}
			asnwer += Character.toString(ch);
		}
		
		return asnwer;
	}

}
