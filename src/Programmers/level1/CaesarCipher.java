package Programmers.level1;

import java.io.*;

public class CaesarCipher { // 시저 암호

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int n = Integer.parseInt(br.readLine());

		System.out.println(solution(s,n));
	}

	private static String solution(String s, int n) {
		// TODO Auto-generated method stub
		String answer = "";
		
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			
			if('A'<=ch && ch<='Z'){
				ch = (char) (ch + n);
				if(ch > 'Z') ch -= 26;
			}
			if('a'<=ch && ch<='z'){
				ch = (char) (ch + n);
				if(ch > 'z') ch -= 26;
			}
			answer += ch;
		}
		return answer;
	}

}
