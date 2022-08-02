package baekjoon.gold5;

import java.io.*;
import java.util.*;

public class Baekjoon_5557 {
	public static int result;
	public static int m[][];
	
	public static void main(String[] args) throws IOException {
		
//		ù° �ٿ� ������ ���� N�� �־�����. (3 �� N �� 100) ��° �ٿ��� 0 �̻� 9 ������ ���� N���� �������� ������ �־�����.
//
//		���
//		ù° �ٿ� ����̰� ���� �� �ִ� �ùٸ� ����� ������ ����Ѵ�. �� ���� 263-1 �����̴�.
//
//		���� �Է� 1 
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
