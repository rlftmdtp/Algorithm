package baekjoon.gold5;

import java.util.*;
import java.io.*;

public class Baekjoon_2230 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		int N = Integer.parseInt(strSplit[0]);
		int M = Integer.parseInt(strSplit[1]);
		int A[] = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(A);
		twoPointer(A, M);
	}
	
	public static int twoPointer(int A[], int search) {
		int st = 0;
		int en = 0;
		
		// 가장 작은 차이
		int MIN = Integer.MAX_VALUE;
		for(st=0; st<A.length; st++) {
			while(en < A.length && A[en]-A[st]<search) en++;
			if(en == A.length) break;
			if(MIN > A[en]-A[st]) MIN = A[en]-A[st];
		} 
		System.out.println(MIN);
		return MIN;
	}

}
