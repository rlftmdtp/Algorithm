package CodeUp.Recursion;

import java.io.*;

public class CodeUp_2748 { // 덧셈, 뺄셈으로 n만들기
	public static int M;
	public static int N;
	public static int list[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	    M = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		if (N == 0) { // N이 0부터라 제외처리
			System.out.println(0);
			return;
		}
		String strSplit[] = br.readLine().split("\\s");
		
		list = new int[N];
		for(int i=0; i<strSplit.length; i++) {
			list[i] = Integer.parseInt(strSplit[i]);
		}

		System.out.println(findZero(0, 0));
	}

	private static int findZero(int sum, int i) {
		// TODO Auto-generated method stub
		// 현재까지의 진행값에 plus의 경우와 minus의 경우로 나눈다 f(n) = f(n-1)플러스의경우 + 현재값
		//                                        f(n) = f(n-1)마이너스의경우 + 현재값
		int result = 0;
		if(sum == M && i == N) {
			return 1;
		}else if(i >= N) return 0;
		else {
				result += findZero(sum + list[i], i+1);		
				result += findZero(sum - list[i], i+1);
		}
		return result;
	}
	
}
