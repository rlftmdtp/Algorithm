package baekjoon.silver3;

import java.util.*;
import java.io.*;

public class Baekjoon_1904 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(n == 1) System.out.println(1);
		else if(n == 2) System.out.println(2);
		else {
			int dp[] = new int[n];
			dp[0] = 1;
			dp[1] = 2;
			
			for(int i=2; i<n; i++) {
				dp[i] = (dp[i-1] + dp[i-2]) % 15746;;
			}
			
			System.out.println(dp[n-1]);	
		}
	}

}
