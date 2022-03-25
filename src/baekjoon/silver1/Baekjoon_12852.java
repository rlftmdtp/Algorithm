package baekjoon.silver1;

import java.io.*;
import java.util.*;

public class Baekjoon_12852 {
	public static List<Integer> list = new ArrayList<>();
	public static int before[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub	
		// String[] purchase = {"2019/01/01 5000", "2019/01/20 15000", "2019/02/09 90000"};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		before = new int[n+110];
		dp(n);
		
		int pre = n;
		while(true) {
			System.out.print(pre + " ");
			if(pre == 1) break;
			pre = before[pre];
		}
	}
	
	public static int dp(int n) {
		if(n <= 3) return 1;
		
		int dp[] = new int[n+1];
		dp[1] = 0;

		for(int i=2; i<=n; i++) {
			before[i] = i-1;
			dp[i] = dp[i-1]+1;
			if(i%2 == 0 && dp[i/2] + 1 < dp[i]) {
				dp[i] = dp[i/2] + 1;
				before[i] = i/2;
			}
			if(i%3 == 0 && dp[i/3] + 1 < dp[i]) {
				dp[i] = dp[i/3]+1;
				before[i] = i/3;
			}
		}
		
		System.out.println(dp[n]);
		return dp[n];
	}
}
