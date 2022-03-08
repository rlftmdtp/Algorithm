package baekjoon.silver3;

import java.util.*;
import java.awt.List;
import java.io.*;

public class Baekjoon_9461 { // 파도반 수열

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		long dp[] = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;	
		for(int i=4; i<=100; i++) {
			dp[i] = dp[i-2] + dp[i-3];
		}
		
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb.append(dp[Integer.parseInt(br.readLine())] + "\n");
		}

		System.out.println(sb.toString());
	}

}
