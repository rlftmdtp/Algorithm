package Programmers.level1;

import java.io.*;

public class PhoneNumberBlind { // 핸드폰 번호 가리기
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		System.out.println(solution(s));
	}

	private static String solution(String s) {
		// TODO Auto-generated method stub
		String asnwer = "";
		for(int i=0; i<s.length()-4; i++) {
			asnwer += "*";
		}
		// 뒷 4자리를 제외한 나머지 *처리
		asnwer += s.substring(s.length()-4, s.length());
		return asnwer;
	}

}
