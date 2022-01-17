package baekjoon.silver4;

import java.util.*;
import java.io.*;

public class Baekjoon_1920 {
	public static int list[];
	public static int list2[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		list = new int[N];
		String strSplit[] = br.readLine().split(" ");
		for(int i=0; i<strSplit.length; i++) {
			list[i] = Integer.parseInt(strSplit[i]);
		}
		
		int M = Integer.parseInt(br.readLine());
		list2 = new int[M];
		strSplit = br.readLine().split(" ");
		for(int i=0; i<strSplit.length; i++) {
			list2[i] = Integer.parseInt(strSplit[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<list2.length; i++) {
			int search = list2[i];
			sb.append(binarySearch(0, list.length-1, search) + "\n");
		}
		System.out.println(sb);
	}
	
	public static int binarySearch(int start, int end, int search) {
		int mid = (start+end)/2;
		if(list[mid] == search) {
			return 1;
		}else if(start < end){
			return binarySearch(start, mid-1, search) + binarySearch(mid+1, end, search);
		}else return 0;
	}

}
