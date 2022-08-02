package baekjoon.gold5;

import java.io.*;
import java.util.*;

public class Baekjoon_5557 {
	public static int result;
	public static int m[][];
	
	public static void main(String[] args) throws IOException {
		
//		첫째 줄에 숫자의 개수 N이 주어진다. (3 ≤ N ≤ 100) 둘째 줄에는 0 이상 9 이하의 정수 N개가 공백으로 구분해 주어진다.
//
//		출력
//		첫째 줄에 상근이가 만들 수 있는 올바른 등식의 개수를 출력한다. 이 값은 263-1 이하이다.
//
//		예제 입력 1 
//		11
//		8 3 2 4 8 7 2 4 0 8 8
		
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int list[] = new int[n];
		String strSplit[] = br.readLine().split(" ");
		for(int i=0; i<strSplit.length; i++) {
			list[i] = Integer.parseInt(strSplit[i]);
		}
		m = new int[n+1][21];
		// memorization(list, n, 0);
		combi(list, 0, 0);
		System.out.println(m[n][list[list.length-1]]);
	}
	

	
	public static int combi(int[] list, int depth, int sum) {
		if(depth == list.length-1) {
			// System.out.println("depth = " + depth + " sum = " + sum);
			if(sum == list[list.length-1]) {
				return 1;
			}
		}
		else if(m[depth][sum] != 0) return m[depth][sum];
		else {
			if(sum >= 0 && sum <= 20) {
				return m[depth][sum] += combi(list, depth+1, sum + list[depth]) + 
				combi(list, depth+1, sum - list[depth]);
			}
		}
		
		return 0;
	}

}
