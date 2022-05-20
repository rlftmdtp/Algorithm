package baekjoon.bronze;

import java.io.*;
import java.util.*;


public class Baekjoon_11050 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		int N = Integer.parseInt(strSplit[0]);
		int R = Integer.parseInt(strSplit[1]);
		
		int C[][] = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			C[i][i] = 1;
			C[i][0] = 1;
			for(int j=1; j<i; j++) {
				// System.out.println(C[i-1][j-1] + " " +  C[i-1][j]);
				C[i][j] = C[i-1][j-1] + C[i-1][j];
			}
		}
		
		System.out.println(C[N][R]);
	}

}
