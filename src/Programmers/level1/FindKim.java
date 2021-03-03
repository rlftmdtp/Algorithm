package Programmers.level1;

import java.io.*;

public class FindKim { // 서울에서 김서방 찾기

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String seoul[] = br.readLine().split("\\s");
		
		System.out.println(solution(seoul));
	}

	private static String solution(String[] seoul) {
		// TODO Auto-generated method stub
		for(int i=0; i<seoul.length; i++) {
			if(seoul[i].equals("Kim")) return "김서방은 " + i + "에 있다";
		}
		return "정답없음";
	}	

}
