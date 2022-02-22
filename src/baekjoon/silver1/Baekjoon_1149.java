package baekjoon.silver1;

import java.io.*;
import java.util.*;

public class Baekjoon_1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int rgb[][] = new int[n][n];
		for(int i=0; i<n; i++) {
			String strSplit[] = br.readLine().split(" ");
			
			rgb[i][0] = Integer.parseInt(strSplit[0]);
			rgb[i][1] = Integer.parseInt(strSplit[1]);
			rgb[i][2] = Integer.parseInt(strSplit[2]);
		}
		
		int dp[][] = new int[n][n];
		dp[0][0] = rgb[0][0];
		dp[0][1] = rgb[0][1];
		dp[0][2] = rgb[0][2];
		for(int i=1; i<rgb.length; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + rgb[i][2]; 
		}
		int result = Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
		System.out.println(result);
	}

}
