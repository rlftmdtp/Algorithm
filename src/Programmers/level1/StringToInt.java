package Programmers.level1;

import java.io.*;

public class StringToInt {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		System.out.println(solution(s));
	}

	private static int solution(String s) {
		// TODO Auto-generated method stub
		// ��ȣ ó��
		int next = 1;
		if(s.charAt(0) == '+' || s.charAt(0) == '-') {
			if(s.charAt(0) == '-') next = -1;
			// ��ȣ ����
			s = s.substring(1, s.length());
		}
		return Integer.parseInt(s) * next;
	}

}
