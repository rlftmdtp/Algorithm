package baekjoon.gold5;

import java.io.*;
import java.util.*;

public class Baekjoon_12865 {
	public static int dp[][];
	public static int W[];
	public static int V[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		int N = Integer.parseInt(strSplit[0]);
		int K = Integer.parseInt(strSplit[1]);
		
		dp = new int[N+1][K+1];
		/*
		 * for(int i=0; i<=N; i++) { Arrays.fill(dp[i], -1); }
		 */
		W = new int[N+1];
		V = new int[N+1];
		for(int i=1; i<=N; i++) {
			strSplit = br.readLine().split(" ");
			int weight = Integer.parseInt(strSplit[0]);
			int value = Integer.parseInt(strSplit[1]);
			W[i] = weight;
			V[i] = value;
		}
		
		// Top-Down(皋葛府力捞记 规侥)
		// TopDown(N,K);
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				if(W[i] > j) dp[i][j] = dp[i-1][j];
				else dp[i][j] = Math.max(dp[i-1][j-W[i]] + V[i], dp[i-1][j]);
			}
		}
		
		System.out.println(dp[N][K]);
	}
	
	public static int TopDown(int n, int w) {
		System.out.println("n " + n + " w " + w);
		if(n == 0) return 0;
		else if(dp[n][w] != -1) return dp[n][w];
		else {
			if(W[n] > w) return dp[n][w] = TopDown(n-1,w);
			else {
				return dp[n][w] = Math.max(TopDown(n-1,w-W[n]) + V[n], TopDown(n-1,w));
			}
		}
	}

}
