package Programmers.level1;

import java.io.*;

public class Harshad { // 하샤드 수

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		// 각 자리수를 더해서 그 수로 나누어 떨어지는가?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(solution(n));
	}

	private static boolean solution(int n) {
	// TODO Auto-generated method stub
		int tempN = n;
		int total = 0;
		
		while(tempN!=0) {
			total += tempN%10;
			tempN = tempN/10;
		}
		
		boolean answer = false;
		if(n%total == 0) answer = true;
		return answer;
	}	

}
