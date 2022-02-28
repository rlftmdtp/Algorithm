package baekjoon.silver4;

import java.io.*;
import java.util.*;

public class Baekjoon_1026 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int A[] = new int[N];
		int B[] = new int[N];
		
		String strSplit[] = br.readLine().split(" ");
		for(int i=0; i<strSplit.length; i++) {
			A[i] = Integer.parseInt(strSplit[i]);
		}
		
		strSplit = br.readLine().split(" ");
		for(int i=0; i<strSplit.length; i++) {
			B[i] = Integer.parseInt(strSplit[i]);
		}
		
		// A 정렬
		Arrays.sort(A);
		int sum = 0;
		for(int i=0; i<A.length; i++) {
			int n = A[i];
			
			int index = 0;
			for(int j=0; j<B.length; j++) {
				if(B[j] > B[index] && B[j] != -1) index = j;
			}
			// 가장 큰 B와 가장 작은 A
			sum += n * B[index];
			B[index] = -1;
		}
		System.out.println(sum);
	}

}
