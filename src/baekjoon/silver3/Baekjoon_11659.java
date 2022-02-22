package baekjoon.silver3;

import java.io.*;
import java.util.*;

public class Baekjoon_11659 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(strSplit[0]);
		int m = Integer.parseInt(strSplit[1]);
		int list[] = new int[n+1];
		strSplit = br.readLine().split(" ");
		for(int i=0; i<strSplit.length; i++) {
			list[i+1] = Integer.parseInt(strSplit[i]);
		}
		
		// DP , prefix sum ¹æ¹ý 
		// A[i] + A[i+1] ... + A[j] = (A[1] + A[2] +  + A[i-1]) - (A[1] + A[2] + ... + A[j]) = D[j] - D[i-1];
		int dp[] = new int[n+1];
		for(int i=1; i<=n; i++) {
			dp[i] = dp[i-1] + list[i];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			strSplit = br.readLine().split(" ");
			int start = Integer.parseInt(strSplit[0]);
			int end = Integer.parseInt(strSplit[1]);
			
			int sum = dp[end] - dp[start-1];
			sb.append(sum + "\n");
		}
		System.out.println(sb.toString());
	}

}
