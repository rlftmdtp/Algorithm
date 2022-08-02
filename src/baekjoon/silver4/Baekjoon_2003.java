package baekjoon.silver4;

import java.util.*;
import java.io.*;

public class Baekjoon_2003 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		4 2
//		1 1 1 1
		String strSplit[] = br.readLine().split(" ");
		int n = Integer.parseInt(strSplit[0]);
		int m = Integer.parseInt(strSplit[1]);
		
		int list[] = new int[n];
		strSplit = br.readLine().split(" ");
		for(int i=0; i<strSplit.length; i++) {
			list[i] = Integer.parseInt(strSplit[i]);
		}
				
		// 투포인터
		twoPointer(list,0,0,m);
	}
	
	public static int twoPointer(int list[], int start, int end, int m) {
		int result = 0;
		int sum = 0;
		while(true) {
			
			if(end == list.length && m<sum) sum -= list[start++];
			else if(end == list.length && m>sum) break;
			else if(m <= sum) sum -= list[start++];
			else if(m > sum) sum += list[end++];
			if(m == sum) result++;
		}
		
		System.out.println(result);
		return result;
	}

}
