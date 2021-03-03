package Programmers.level1;

import java.io.*;

public class MiddleString { // 가운데 글자 가져오기

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		System.out.println(solution(s));
	}

	private static String solution(String s) {
		// TODO Auto-generated method stub
		String resturnS = "";
		if(s.length()%2 == 1) return resturnS += s.charAt(s.length()/2);
		else {
			resturnS += s.charAt(s.length()/2 - 1);
			resturnS += s.charAt(s.length()/2);
			return resturnS;
		}
	}

}
