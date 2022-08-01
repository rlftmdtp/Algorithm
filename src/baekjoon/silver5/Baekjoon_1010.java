package baekjoon.silver5;

import java.io.*;

public class Baekjoon_1010 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			String strSplit[] = br.readLine().split(" ");
			int r = Integer.parseInt(strSplit[0]);
			int n = Integer.parseInt(strSplit[1]);
			
			int c[][] = new int[n+1][n+1];
			c[0][0] = 1;
			
			for(int j=1; j<=n; j++) {
				c[j][0] = 1;
				for(int z=1; z<=j; z++) {
						// System.out.println("j = " + j + " z  = " + z);
						c[j][z] = c[j-1][z-1] + c[j-1][z];
				}
			}
			
			// System.out.println(c[n][r]);
			sb.append((c[n][r]) + "\n");
		}
	
		System.out.println(sb.toString());
	}

}
