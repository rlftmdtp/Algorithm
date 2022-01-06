package baekjoon.bronze;

import java.util.*;
import java.io.*;

public class Baekjoon_2740 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		int N = Integer.parseInt(strSplit[0]);
		int M = Integer.parseInt(strSplit[1]);
		
		int A[][] = new int[N][M];
		for(int i=0; i<N; i++) {
			strSplit = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				A[i][j] = Integer.parseInt(strSplit[j]);
			}
		}
		
		strSplit = br.readLine().split(" ");
		M = Integer.parseInt(strSplit[0]);
		int K = Integer.parseInt(strSplit[1]);
		int B[][] = new int[M][K];
		for(int i=0; i<M; i++) {
			strSplit = br.readLine().split(" ");
			for(int j=0; j<K; j++) {
				B[i][j] = Integer.parseInt(strSplit[j]);
			}
		}
		
		// 정답 구하기
		int result[][] = new int[N][K];
		for(int i=0; i<A.length; i++) {
			for(int z=0; z<B[0].length; z++) {
				for(int j=0; j<A[0].length; j++) {
					result[i][z] += A[i][j]*B[z][j];
				}
			}
		}
		
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
