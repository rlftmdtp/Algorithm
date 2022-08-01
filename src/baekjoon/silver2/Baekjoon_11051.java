package baekjoon.silver2;

import java.io.*;

public class Baekjoon_11051 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
			String strSplit[] = br.readLine().split(" ");
			int n = Integer.parseInt(strSplit[0]);
			int r = Integer.parseInt(strSplit[1]);
			
			int c[][] = new int[n+1][n+1];
			c[0][0] = 1;
			
			for(int j=1; j<=n; j++) {
				c[j][0] = 1;
				for(int z=1; z<=j; z++) {
						// System.out.println("j = " + j + " z  = " + z);
						c[j][z] = (c[j-1][z-1] + c[j-1][z])%10007;
				}
			}
			
			// System.out.println(c[n][r]);
			sb.append((c[n][r]) + "\n");
	
		System.out.println(sb.toString());
	}

}
