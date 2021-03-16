package Programmers.level1;

import java.io.*;

public class XInterval {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(solution(x,n));
	}

	private static long[] solution(int x, int n) {
		// TODO Auto-generated method stub
		long[] answer = new long[n];
		for(int i=0; i<n; i++) {
			answer[i] = x*(i+1);
		}
		
		return answer;
	}

}
