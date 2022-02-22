package baekjoon.silver3;

import java.io.*;
import java.util.*;

public class Baekjoon_2579 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int stair[] = new int[301];
		int dp[] = new int[301];
		for(int i=1; i<=N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		// ÃÊ±âÈ­
		dp[1] = stair[1];
		dp[2] = stair[2] + stair[1];
		dp[3] = Math.max(stair[3]+stair[2], stair[3]+dp[1]);
		
		for(int i=4; i<=N; i++) {
			dp[i] = Math.max(stair[i]+dp[i-1], stair[i]+dp[i-2]);
		}
			
		System.out.println(dp[N]);
	}

}
