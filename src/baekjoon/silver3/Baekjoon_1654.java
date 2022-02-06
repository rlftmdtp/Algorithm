package baekjoon.silver3;

import java.io.*;
import java.util.*;

public class Baekjoon_1654 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		
		int K = Integer.parseInt(strSplit[0]);
		int N = Integer.parseInt(strSplit[1]);
		
		int list[] = new int[K];
		for(int i=0; i<K; i++) {
			int len = Integer.parseInt(br.readLine());
			list[i] = len;
		}
		
		Arrays.sort(list);
		System.out.println(upperBoundary(list, N));

	}
	
	public static int upperBoundary(int list[], int search) {
		
		int start = 0;
		int end = list[list.length-1];
		int mid = 0;
		// 찾고자 하는 것 ? 랜선의 최대 길이
		// 잘린 랜선의 개수
		while(start < end) {
			mid = (start+end)/2;
			
			int count = 0;
			for(int i=0; i<list.length; i++) {
				int len = list[i];
				count += len/mid;
			}
			System.out.println("길이= " + mid + " 총 갯수 " + count);
			
			if(count < search) end = mid;
			else start = mid + 1;
		}
		System.out.println("최종 길이 " + start);
		return start-1;
	}

}
