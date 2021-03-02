package Programmers.level1;

import java.io.*;

public class TwoIntPlus { // 두 정수 사이의 합 

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		solution(a, b);
	}

	private static long solution(int a, int b) {
		// TODO Auto-generated method stub
		int start = 0;
		int end = 0;
		if(a > b) {
			start = b;
			end = a;
		}else if(a < b) {
			start = a;
			end = b;
		}else return a;
		
		long result = 0;
		for(int i=start; i<=end; i++) {
			result += i;
		}
		return result;
	}

}
