package Programmers.level1;

import java.io.*;

public class PhoneNumberBlind { // �ڵ��� ��ȣ ������
	

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
		// �� 4�ڸ��� ������ ������ *ó��
		asnwer += s.substring(s.length()-4, s.length());
		return asnwer;
	}

}
