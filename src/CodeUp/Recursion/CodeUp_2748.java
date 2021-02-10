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
		String strSplit[] = br.readLine().split("\\s");
		
		list = new int[N];
		for(int i=0; i<strSplit.length; i++) {
			list[i] = Integer.parseInt(strSplit[i]);
		}
		int sum = 0;
		System.out.println(findZero(sum, 0));
	}

	private static int findZero(int sum, int start) {
		// TODO Auto-generated method stub
		// 현재까지의 진행값 plus의 경우와 minus의 경우로 나눈다  f(n) = f(n-1)플러스의경우 + 현재값
		//                                            f(n) = f(n-1)마이너스의경우 + 현재값
		int result = 0;
		if(sum == M) {
			System.out.println("sum == M " + sum);
			return 1;
		}else if(start >= N) { System.out.println("start >= N " + sum + " " + start);
			return 0;
		}
		else {
			for(int i=start; i<N; i++) {
				System.out.println("sum " + sum + " start " + start);
				result += findZero(sum + list[i], i+1);		
				System.out.println("ㅇㅅㅇ");
				result += findZero(sum - list[i], i+1); // 마이너스 경우
			}
		}
		return result;
	}
	
	// 뒤의 값이 -인경우 +로 전환 ( ex. -1 - (-1))
	private static int sumMethod(int a, int b) {
		if(b<0) {
			b = b*-1;
		}
		return a+b;
	}

}
