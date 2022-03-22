package baekjoon.silver5;

import java.io.*;
import java.util.*;

public class Baekjoon_11728 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		int N = Integer.parseInt(strSplit[0]);
		int M = Integer.parseInt(strSplit[1]);
		
		int list1[] = new int[N];
		int list2[] = new int[M];
		
		strSplit = br.readLine().split(" ");
		for(int i=0; i<strSplit.length; i++) {
			list1[i] = Integer.parseInt(strSplit[i]);
		}
		
		strSplit = br.readLine().split(" ");
		for(int i=0; i<strSplit.length; i++) {
			list2[i] = Integer.parseInt(strSplit[i]);
		}
		
		// 두 개의 리스트를 합친 후 정렬 (합병정렬 방식 사용)
		int left = 0;
		int right = 0;
		int result[] = new int[N+M];
		for(int i=0; i<N+M; i++) {
			if(left == N) result[i] = list2[right++];
			else if(right == M) result[i] = list1[left++];
			else if(list1[left] <= list2[right]) result[i] = list1[left++];
			else result[i] = list2[right++];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : result) {
			sb.append(i + " ");
		}
		System.out.println(sb.toString());
	}

}
