package Programmers.level1;

import java.io.*;

public class FindKim { // ���￡�� �輭�� ã��

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String seoul[] = br.readLine().split("\\s");
		
		System.out.println(solution(seoul));
	}

	private static String solution(String[] seoul) {
		// TODO Auto-generated method stub
		for(int i=0; i<seoul.length; i++) {
			if(seoul[i].equals("Kim")) return "�輭���� " + i + "�� �ִ�";
		}
		return "�������";
	}	

}
