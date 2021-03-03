package Programmers.level1;

import java.io.*;
import java.util.*;

public class IntDesc { // ���� ������������ ��ġ�ϱ�

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		System.out.println(solution(n));
		}

	private static long solution(long n) {
		// TODO Auto-generated method stub
		String s = Long.toString(n);
		char ch[] = s.toCharArray();
		Character ch2[] = new Character[ch.length];
		for(int i=0; i<ch.length; i++) {
			ch2[i] = ch[i];
		}
		// primirity�� ������������ �ϰ� ���� �� ���������� ���� Collections.reverseOrder()�� ���
		Arrays.sort(ch2, Collections.reverseOrder());
		
		s = "";
		for(int i=0; i<ch2.length; i++) {
			s += ch2[i];
		}
		return Long.parseLong(s);
	}

}
